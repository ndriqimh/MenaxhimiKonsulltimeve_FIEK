package code;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;


public class I18N {

	public static ObjectProperty<Locale> locale;
	
	static {
		locale = new SimpleObjectProperty<>(getDefaultLocale());
	}
	
	
	public static List<Locale> getLanguages() {
		return new ArrayList<Locale>(Arrays.asList(Locale.ENGLISH, new Locale("al", "AL")));
	}
	
	public static Locale getDefaultLocale() {
		return Locale.ENGLISH;
	}

	public static Locale getLocale() {
		return locale.get();
	}
	
	public static void setLocale(Locale locale) {
		localProperty().set(locale);
	}
	
	public static ObjectProperty<Locale> localProperty() {
		return locale;
	}
	
	public static String get(String key, Object... args) {
		ResourceBundle bundle = ResourceBundle.getBundle("code.translates.translate", getLocale());
	
		return MessageFormat.format(bundle.getString(key), args);	
	}
	
	public static StringBinding createStringBinding(String key, Object... args) {
		return Bindings.createStringBinding(() -> get(key, args), locale);
	}
	
	// te nalt mos prekni send.
	
	// ktu te poshte shtohen funksionet per labela senet qka kan me iu ndrru gjuha 
	public static Label getLabel(String key, Object... args) {
		Label label = new Label();
		label.textProperty().bind(createStringBinding(key, args));
		return label;		
	}
	public static Button getButton(String key, Object... args) {
		Button button = new Button();
		button.textProperty().bind(createStringBinding(key, args));
		return button;		
	}
	public static Menu getMenu(String key, Object... args) {
		Menu menu = new Menu();
		menu.textProperty().bind(createStringBinding(key, args));
		return menu;	
		
	}
	public static MenuItem getMenuItem(String key, Object... args) {
		MenuItem m = new MenuItem();
		m.textProperty().bind(createStringBinding(key, args));
		return m;	
		
	}
	public static RadioButton getRadioButton(String key, Object... args) {
		RadioButton button = new RadioButton();
		button.textProperty().bind(createStringBinding(key, args));
		return button;		
	}
	

	
}
