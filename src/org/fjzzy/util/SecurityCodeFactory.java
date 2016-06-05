package org.fjzzy.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
public class SecurityCodeFactory {
	public static SecurityCode getSecurityCode(){
		SecurityCode securityCode = new SecurityCode();
		//设置画布
		BufferedImage img = new BufferedImage(100, 40, BufferedImage.TYPE_INT_BGR);
		Graphics g = img.getGraphics();
		Random r1 = new Random();
		
		//用彩色圆填充背景
		int w = 0;
		for(int i = 0; i < r1.nextInt(30); i++){
			g.setColor(new Color(r1.nextFloat(),r1.nextFloat(),r1.nextFloat(),r1.nextFloat()));
			w = r1.nextInt(50);
			g.fillOval(r1.nextInt(70), r1.nextInt(30), w, w);
		}
		//设置画笔
		Font font = new Font("华文琥珀", Font.TRUETYPE_FONT, 30);
		g.setFont(font);
		g.setColor(new Color(r1.nextInt(255),r1.nextInt(255),r1.nextInt(255)));
		
		//随机生成4位数，不足4位，后面补0
		StringBuilder num = new StringBuilder(r1.nextInt(9999) + "");
		int len = num.toString().toCharArray().length;
		if(len < 4){
			for(int j = 0; j < 4 - len; j++){
				num.append("0");
			}
		}
		//将4位数画到画布上
		g.drawString(num.toString(), r1.nextInt(30), 30);
		//将验证码转为byte数组
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ImageIO.write(img, "JPEG", bos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		securityCode.setImgData(bos.toByteArray());
		securityCode.setCode(num.toString());
		return securityCode;
	}
}
