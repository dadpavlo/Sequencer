import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniMiniMusicApp extends JPanel implements ActionListener{

    JButton button;
    MiniMiniMusicApp mini;
    MyDrawPanel gg;
    JFrame frame;

    public static void main(String[] args){
        MiniMiniMusicApp gui = new MiniMiniMusicApp();
        gui.go();

    }
    public void go(){
        gg = new MyDrawPanel();
        mini = new MiniMiniMusicApp();
        frame = new JFrame();
        button = new JButton("click me");
        button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER,gg);
        frame.setSize(100,100);
        frame.setVisible(true);
        mini.play();

    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);

                Track track = seq.createTrack();
                int note = (int) (Math.random() * (80-40)+30);
                int t = (int) (Math.random() * (100-50)+50);

                int o = (int) (Math.random() * (32-16)+16);

                ShortMessage a = new ShortMessage();
                a.setMessage(144,1,note,t);
                MidiEvent noteOn = new MidiEvent(a,1);
                track.add(noteOn);

                ShortMessage b = new ShortMessage();
                b.setMessage(128,1,44,100);
                MidiEvent noteOff = new MidiEvent(b, o);
                track.add(noteOff);



            player.setSequence(seq);
            player.start();
            player.start();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        button.setText("playing note");
        mini.play();
//        frame.repaint();
    }

}