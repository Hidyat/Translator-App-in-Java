import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

// Written by: Hedayatullah Yamin
public class TextToSpeech {

  private static Synthesizer synth;

  private static void initializeSynthesizer() {
    try {
      System.setProperty("FreeTTSSynthEngineCentral", "com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
      System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
      Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");

      SynthesizerModeDesc desc = new SynthesizerModeDesc(null, "general", Locale.US, null, null);
      synth = Central.createSynthesizer(desc);
      synth.allocate();

      desc = (SynthesizerModeDesc) synth.getEngineModeDesc();
      Voice[] voices = desc.getVoices();
      Voice voice = null;

      for (Voice entry : voices) {
        if (entry.getName().equals("kevin16")) {
          voice = entry;
          break;
        }
      }

      synth.getSynthesizerProperties().setVoice(voice);
      synth.resume();
    }

    catch (Exception ex) {
      System.out.println("Error initializing synthesizer: " + ex);
    }
  }

  public static void speech(String text) {
    initializeSynthesizer();

    if (text != null && !text.trim().isEmpty()) {
      try {
        synth.speakPlainText(text, null);
        synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
      }

      catch (Exception ex) {
        System.out.println("Error during speech: " + ex);
      }
    }
  }
}
