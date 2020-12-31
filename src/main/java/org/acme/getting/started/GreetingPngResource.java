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

@Path("/png")
public class GreetingPngResource {

    @GET
    @Produces("image/png")
    public byte[] hello() throws IOException {
        BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/mountains.png"));
        BufferedImage watermark = ImageIO.read(getClass().getResourceAsStream("/watermark.png"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Thumbnails.of(image)
            .scale(0.7)
            .watermark(Positions.BOTTOM_RIGHT, watermark, 0.2f)
            .outputFormat("png")
            .toOutputStream(baos);

        return baos.toByteArray();
    }
}