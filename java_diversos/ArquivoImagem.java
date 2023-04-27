package java_diversos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArquivoImagem 
{
	public static void main(String[] args) 
	{
		plotarImagem("temp/teste.png");
	}

	
	public static void plotarImagem(String caminhoArquivo)
	{			
		JFrame jFrame;
		MyPanelCanvas myPanelCanvas;

		BufferedImage imagem = null;
		FileInputStream fileInputStream;

		int altura = 0;
		int largura = 0;
		
		// Abre imagem:
		try 
		{
			fileInputStream = new FileInputStream(caminhoArquivo);
			imagem = ImageIO.read(fileInputStream);
			
			altura  = imagem.getHeight();
			largura = imagem.getWidth();
			
			System.out.println("altura = " + altura);
			System.out.println("largura = " + largura);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			
		// Frame com Panel
		jFrame = new JFrame("Meu Canvas");
		jFrame.setSize(400, 400);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		myPanelCanvas = new MyPanelCanvas(imagem);
			
		jFrame.add(myPanelCanvas);
	}
}




class MyPanelCanvas extends JPanel 
{
	private static final long serialVersionUID = -4566173464847947008L;
	
	private BufferedImage imagem;
	
	public MyPanelCanvas(BufferedImage imagem) {
		this.imagem = imagem;
	}
	
    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);

		Color c = null;
		
		for (int y = 0; y < imagem.getHeight(); y++) 
		{
			System.out.println();
			
			for (int x = 0; x < imagem.getWidth(); x++) 
			{
				c = new Color(imagem.getRGB(x, y));
				
				g.setColor(c);
				g.fillRect(x, y, 1, 1);
			}
		}

    }
    
}
