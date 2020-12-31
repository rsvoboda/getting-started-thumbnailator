package org.acme.getting.started;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces("image/jpeg")
    public byte[] hello() throws IOException {
        BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/original.jpg"));
        BufferedImage watermark = ImageIO.read(getClass().getResourceAsStream("/watermark.png"));

        BufferedImage outputImage = Thumbnails.of(image)
            .scale(0.7)
            .watermark(Positions.BOTTOM_RIGHT, watermark, 0.2f)
            .outputQuality(0.8)
            .asBufferedImage();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(outputImage, "jpg", baos);
        byte[] imageData = baos.toByteArray();
        
        return imageData;
    }
}