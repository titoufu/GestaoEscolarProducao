package utilAlerts;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Resolucao {

	public static double widtht(double res) {
		Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		double width = screenBounds.getWidth() * res / 1920.0;
		return width;
	}

	public static double height(double res) {
		Rectangle2D screenBounds = Screen.getPrimary().getBounds();
		double height = screenBounds.getHeight() * res / 1080.0;
		return height;
	}

}