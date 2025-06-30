import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Threads extends Thread{
    public static int Truncate(int value){
        if (value < 0) value=0;
        else if (value > 255) value=255;
        return value;
    }
    BufferedImage image;
    public void painting(String path){
        try {
            image= ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(String path){

        try {
            ImageIO.write(image, "jpg",new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void method(String Path,String OutPath) throws IOException {
        painting(Path);
        int rgb[];
        int brightnessValue=50;
        for (int i = 0; i <image.getWidth(); i++) {
            for (int j = 0; j <image.getHeight() ; j++) {
                rgb = image.getRaster().getPixel(i,j,new int[3]);
                int red=Truncate(rgb[0]+brightnessValue);
                int green=Truncate(rgb[1]+brightnessValue);
                int blue=Truncate(rgb[2]+brightnessValue);
                int arr[]={red,green,blue};
                image.getRaster().setPixel(i,j,arr);
            }
        }
    save(OutPath);
    }
    public void methodMultithreads(int brightnessIncrease) throws InterruptedException {
        int numCores=Runtime.getRuntime().availableProcessors();
        int width=image.getWidth();
        int height=image.getHeight();
        Thread[] threads=new Thread[numCores];
        int rowsPerThread=height/numCores;
        int remainingRows=height%numCores;
        for (int i = 0; i < numCores; i++) {
            int startY = i*rowsPerThread;
            int endY = startY+rowsPerThread-1;
            if (i==numCores-1){
                endY+=remainingRows;
            }
            endY=Math.min(endY,height-1);
            threads[i]=new Thread(new BrightnessWorker(this.image,brightnessIncrease,startY,endY,width));

            threads[i].start();
        }
        for (int i = 0; i < numCores; i++) {
            threads[i].join();
        }
    }
    private static class BrightnessWorker implements Runnable{
        private final BufferedImage image;
        private final int brightnessIncrese;
        private final int startY;
        private final int endY;
        private final int width;
        private final int[] pixelComponents;

        private BrightnessWorker(BufferedImage image, int brightnessIncrese, int startY, int endY, int width) {
            this.image = image;
            this.brightnessIncrese = brightnessIncrese;
            this.startY = startY;
            this.endY = endY;
            this.width = width;
            this.pixelComponents = new int[image.getRaster().getNumBands()];
        }

        @Override
        public void run() {
            for (int y=this.startY;y<=this.endY;y++){
                for (int x = 0; x < this.width; x++) {
                    this.image.getRaster().getPixel(x,y,this.pixelComponents);
                    for (int i = 0; i < this.pixelComponents.length; i++) {
                        this.pixelComponents[i]=Math.max(0,Math.min(255, this.pixelComponents[i]+this.brightnessIncrese));
                    }
                    this.image.getRaster().setPixel(x,y,this.pixelComponents);
                }
            }
        }
    }

}
