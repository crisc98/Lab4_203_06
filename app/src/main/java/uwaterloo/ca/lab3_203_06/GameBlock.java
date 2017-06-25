package uwaterloo.ca.lab3_203_06;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;

public class GameBlock extends AppCompatImageView {
    float velocity = 0, blockx, blocky;
    Timer time;
    ImageView gameBoard;

    public GameBlock(RelativeLayout rl, int img, float x, float y, Context ctx, Timer time,  ImageView gameBoard) {
        super(ctx);
        setImageResource(img);
        setX(x);
        setY(y);
        rl.addView(this);
        this.time = time;
        this.blockx=x;
        this.blocky=y;
        this.gameBoard=gameBoard;
    }

    public void move(String dir) {
        velocity = 0;
        time.schedule(new GameLoopTask(dir, this, gameBoard, blockx,blocky), 25, 25);
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float v) {
        velocity = v;
    }
}

