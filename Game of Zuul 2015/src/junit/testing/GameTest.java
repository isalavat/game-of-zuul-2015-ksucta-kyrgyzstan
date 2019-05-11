package junit.testing;
import java.awt.image.BufferedImage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.person.Spieler;
import model.resourceloader.PersonsImageLoader;
import model.sprite.SpriteSchneider;
import view.window.Game;

public class GameTest {
	Game game;
	@Before
	public void init(){
	     game = Game.getGame();
	}
	
	@Test
	public void spielerPlusKillCount(){
		Spieler spieler = Spieler.getSpieler();
		spieler.setKillCount(5);
		spieler.plusKillCount();
		Assert.assertTrue(5 != spieler.getKillCount());
	}
	
	@Test
 	public void getSprite(){
		BufferedImage image = PersonsImageLoader.getPersonsImageLoader().getHexeImage();
		BufferedImage sprite = null ;
		int imageWidth;
		int imageHeight;
		int spriteWidth;
		int spriteHeight;
		imageHeight = image.getHeight();
		imageWidth = image.getWidth();
		SpriteSchneider spriteSchneider = new SpriteSchneider(image, 2, 1, 3, 0, 4);
		sprite = spriteSchneider.getSchniedeneSprite(false, false, false, true);
		spriteWidth = sprite.getWidth();
		spriteHeight = sprite.getHeight();
		if ((spriteHeight != imageHeight/4)|(spriteWidth != imageWidth/4)) {
			Assert.fail();
		}
	}
	
	@Test
	public void spielerSchnellGehenOn(){
		Spieler spieler = Spieler.getSpieler();
		spieler.schnellGehenOn();
		Assert.assertTrue(4 == spieler.getSpeed());
	}
	@Test
	public void spielerSchnellGehenOff(){
		Spieler spieler = Spieler.getSpieler();
		spieler.schnellGehenOff();
		Assert.assertTrue(2 == spieler.getSpeed());
	}
}
