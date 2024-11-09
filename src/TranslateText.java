import java.io.IOException;
import com.darkprograms.speech.translator.GoogleTranslate;

// Written by: Hedayatullah Yamin
public class TranslateText {

	public String translateText(String sourceLang, String targetLang,  String text) throws IOException {
		return GoogleTranslate.translate(sourceLang, targetLang, text);
	}

}
