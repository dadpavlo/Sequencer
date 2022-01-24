import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniMiniMusicApp extends JPanel implements ActionListener{
    int p = 1;
    int pp = 4;
    int note = 80;
    GridBagConstraints grid;
    Box f1;
    JFrame frame1;
    JButton button, b1;
    MiniMiniMusicApp mini;
    MyDrawPanel gg;
    JFrame frame;

    public static void main(String[] args){
        MiniMiniMusicApp gui = new MiniMiniMusicApp();


    }
    public void go(){
        grid = new GridBagConstraints();
        gg = new MyDrawPanel();
        mini = new MiniMiniMusicApp();
        frame = new JFrame();
        f1 = new Box(BoxLayout.X_AXIS);
        button = new JButton("click me");
        b1 = new JButton("POP");
        button.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
//
//        frame.getContentPane().add(BorderLayout.CENTER,gg);
//        frame.add(f1);
        frame.setSize(700,700);
        frame.setVisible(true);

    }

    public void play() {
        try {
            for (int i = 0; i < 20; i++) {
                Sequencer player = MidiSystem.getSequencer();
                player.open();
                Sequence seq = new Sequence(Sequence.PPQ, 4);

                Track track = seq.createTrack();
                for (int j = 52; j < 70; j++) {
                    int t = (int) (Math.random() * (100-50)+50);

                    int o = (int) (Math.random() * (32-16)+16);

                    ShortMessage a = new ShortMessage();
                    a.setMessage(144,1,j,50);
                    MidiEvent noteOn = new MidiEvent(a,p);
                    track.add(noteOn);

                    ShortMessage b = new ShortMessage();
                    b.setMessage(128,1,44,50);
                    MidiEvent noteOff = new MidiEvent(b, pp);
                    track.add(noteOff);
                    p= pp +1;
                    pp = p+6;
                }
//                int note = (int) (Math.random() * (80-40)+30);



                player.setSequence(seq);
                player.start();

            }


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