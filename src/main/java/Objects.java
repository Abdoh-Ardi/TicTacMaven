

import com.jogamp.opengl.util.texture.TextureIO;

import javax.media.opengl.GL2;

public class Objects {

//
//    public void circle(GL2 gl) {
//        gl.glBegin(GL2.GL_TRIANGLE_FAN);
//        algorithms.bCircle(1,1,1,2,gl);
//        gl.glEnd();
//    }

    /**
     * NOT USED
     * @param gl
     */
    public void cube(GL2 gl){
        gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3f(1f,0f,0f); //red color
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
        gl.glVertex3f( -1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
        gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad (Top)
        gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Bottom Right Of The Quad (Top)
        gl.glEnd();
    }

    /**
     * NOT USED
     * @param gl
     */
    public void circle(GL2 gl){
        for (double i = 0, counter=0; i <= 2 && counter !=100; i+=0.001 ,counter++) {//number of stacked circles= counter
            circle(i,gl);
        }
    }

    /**
     * NOT USED
     * @param z
     * @param gl
     */
    private void circle(double z,GL2 gl){
        double x,y;
        for(double i =0; i <= 360;){
            gl.glBegin(GL2.GL_TRIANGLES);
            x=1*Math.cos(i);
            y=1*Math.sin(i);
            gl.glVertex3d(x, y,z);
            i=i+.5;
            x=1*Math.cos(i);
            y=1*Math.sin(i);
            gl.glVertex3d(x, y,z);
            gl.glVertex2d(0, 0);
            gl.glEnd();
            i=i+.5;
        }
        gl.glEnd();

    }

    /**
     * NOT USED
     * @param gl
     */
    public  void cubeTutorial(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS);
        gl.glColor3f(1f,0f,0f); //red color
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
        gl.glVertex3f( -1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
        gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad (Top)
        gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Bottom Right Of The Quad (Top)

        gl.glColor3f( 0f,1f,0f ); //green color
        gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad
        gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
        gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
        gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad

        gl.glColor3f( 0f,0f,1f ); //blue color
        gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Front)
        gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad (Front)
        gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
        gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad

        gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
        gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
        gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
        gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Back)
        gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Back)

        gl.glColor3f( 1f,0f,1f ); //purple (red + green)
        gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Left)
        gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Left)
        gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
        gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad

        gl.glColor3f( 0f,1f, 1f ); //sky blue (blue +green)
        gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Right)
        gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Left Of The Quad
        gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
        gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad
        gl.glEnd();

    }

    /**
     * EDIT HERE
     * @param x
     * @param y
     * @param z
     * @param texture
     * @param gl
     */
    public void drawCubeAt(float x,float y,float z,int texture, GL2 gl){
        gl.glTranslatef(x,y,z);
        cube(0.4f,0.4f,0.4f,texture,gl);
    }

    /**
     * EDIT HERE
     * This method draws a cube with given coordinates
     * and applies the given 2d texture  to it
     * @param x
     * @param y
     * @param z
     * @param texture
     * @param gl
     */
    public  void cube(float x,float y,float z,int texture, GL2 gl) {
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
        gl.glBegin(GL2.GL_QUADS);//1
        /*
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2d(1, 1);
//        gl.glVertex2d (0, 0);
        gl.glTexCoord2d(0, 1);
//        gl.glVertex2d (1, 0);
        gl.glTexCoord2d(0, 0);
//        gl.glVertex2d (1, 1);
        gl.glTexCoord2d(1, 0);
//        gl.glVertex2d (0, 1);
        gl.glEnd ();
         */
//        gl.glColor3f(1f,0f,0f); //red color
        gl.glTexCoord2d(1,1);
        gl.glVertex3f(x, y, -z); // Top Right Of The Quad (Top)
        gl.glTexCoord2d(0,1);
        gl.glVertex3f( -x, y, -z); // Top Left Of The Quad (Top)
        gl.glTexCoord2d(0,0);
        gl.glVertex3f( -x, y, z ); // Bottom Left Of The Quad (Top)
        gl.glTexCoord2d(1,0);
        gl.glVertex3f( x, y, z ); // Bottom Right Of The Quad (Top)

//        gl.glColor3f( 0f,1f,0f ); //green color
        gl.glTexCoord2d(1,1);
        gl.glVertex3f( x, -y, z ); // Top Right Of The Quad
        gl.glTexCoord2d(0,1);
        gl.glVertex3f( -x, -y, z ); // Top Left Of The Quad
        gl.glTexCoord2d(0,0);
        gl.glVertex3f( -x, -y, -z ); // Bottom Left Of The Quad
        gl.glTexCoord2d(1,0);
        gl.glVertex3f( x, -y, -z ); // Bottom Right Of The Quad

//        gl.glColor3f( 0f,0f,1f ); //blue color
        gl.glTexCoord2d(1,1);
        gl.glVertex3f( x, y, z ); // Top Right Of The Quad (Front)
        gl.glTexCoord2d(0,1);
        gl.glVertex3f( -x, y, z ); // Top Left Of The Quad (Front)
        gl.glTexCoord2d(0,0);
        gl.glVertex3f( -x, -y, z ); // Bottom Left Of The Quad
        gl.glTexCoord2d(1,0);
        gl.glVertex3f( x, -y, y ); // Bottom Right Of The Quad

//        gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
        gl.glTexCoord2d(1,1);
        gl.glVertex3f( x, -y, -z ); // Bottom Left Of The Quad
        gl.glTexCoord2d(0,1);
        gl.glVertex3f( -x, -y, -z ); // Bottom Right Of The Quad
        gl.glTexCoord2d(0,0);
        gl.glVertex3f( -x, y, -z ); // Top Right Of The Quad (Back)
        gl.glTexCoord2d(1,0);
        gl.glVertex3f( x, y, -z ); // Top Left Of The Quad (Back)

//        gl.glColor3f( 1f,0f,1f ); //purple (red + green)
        gl.glTexCoord2d(1,1);
        gl.glVertex3f( -x, y, z ); // Top Right Of The Quad (Left)
        gl.glTexCoord2d(0,1);
        gl.glVertex3f( -x, y, -z ); // Top Left Of The Quad (Left)
        gl.glTexCoord2d(0,0);
        gl.glVertex3f( -x, -y, -z ); // Bottom Left Of The Quad
        gl.glTexCoord2d(1,0);
        gl.glVertex3f( -x, -y, z ); // Bottom Right Of The Quad

//        gl.glColor3f( 0f,1f, 1f ); //sky blue (blue +green)
        gl.glTexCoord2d(1,1);
        gl.glVertex3f( x, y, -z ); // Top Right Of The Quad (Right)
        gl.glTexCoord2d(0,1);
        gl.glVertex3f( x, y, z ); // Top Left Of The Quad
        gl.glTexCoord2d(0,0);
        gl.glVertex3f( x, -y, z ); // Bottom Left Of The Quad
        gl.glTexCoord2d(1,0);
        gl.glVertex3f( x, -y, -z ); // Bottom Right Of The Quad
        gl.glEnd();

    }

    /**
     * completed method
     *
     * @param texture
     * @param texture2
     * @param gl
     */
    public void table(int texture , int texture2, GL2 gl) {
        //giving different colors to different sides
        // Base wooden table stand object.
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture2);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(1.6f, 1.0f, -1.6f); // Top Right Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(-1.6f, 1.0f, -1.6f); // Top Left Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(-1.6f, -1.2f, 1.4f); // Bottom Left Of The Quad (Top)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(1.6f, -1.2f, 1.4f); // Bottom Right Of The Quad (Top)
        gl.glEnd();

        // Leftmost wooden table object.
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture2);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(-1.6f, 1.0f, -1.6f); // Top below Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(-1.6f, 1.2f, -1.5f); // Top above Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(-1.6f, -1.0f, 1.5f); // Bottom above Of The Quad (Top)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(-1.6f, -1.2f, 1.4f); // Bottom below Of The Quad (Top)
        gl.glEnd();

        // Rightmost wooden table object.
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture2);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(1.6f, 1.0f, -1.6f); // Top below Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(1.6f, 1.2f, -1.5f); // Top above Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(1.6f, -1.0f, 1.5f); // Bottom above Of The Quad (Down)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(1.6f, -1.2f, 1.4f); // Bottom below Of The Quad (Down)
        gl.glEnd();

        // Above base backword wooden object
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture2);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(1.6f, 1.2f, -1.5f); // Top Right Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(-1.6f, 1.2f, -1.5f); // Top Left Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(-1.6f, 1.0f, -1.6f); // Bottom Left Of The Quad (Top)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(1.6f, 1.0f, -1.6f); // Bottom Right Of The Quad (Top)
        gl.glEnd();

        // Below base Front wooden object
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture2);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(1.6f, -1.0f, 1.5f); // Top Right Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(-1.6f, -1.0f, 1.5f); // Top Left Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(-1.6f, -1.2f, 1.5f); // Bottom Left Of The Quad (Top)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(1.6f, -1.2f, 1.5f); // Bottom Right Of The Quad (Top)
        gl.glEnd();

        // Left front wooden object.
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture2);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(-1.5f, 1.2f, -1.5f); // Top Right Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(-1.6f, 1.2f, -1.5f); // Top Left Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(-1.6f, -1.0f, 1.5f); // Bottom Left Of The Quad (Top)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(-1.5f, -1.0f, 1.5f); // Bottom Right Of The Quad (Top)
        gl.glEnd();

        // Right front wooden object.
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture2);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(1.6f, 1.2f, -1.5f); // Top Right Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(1.5f, 1.2f, -1.5f); // Top Left Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(1.5f, -1.0f, 1.5f); // Bottom Left Of The Quad (Top)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(1.6f, -1.0f, 1.5f); // Bottom Right Of The Quad (Top)
        gl.glEnd();

        // Above front wooden object.
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture2);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(1.5f, 1.2f, -1.5f); // Top Right Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(-1.5f, 1.2f, -1.5f); // Top Left Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(-1.5f, 1.1f, -1.35f); // Bottom Left Of The Quad (Top)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(1.5f, 1.1f, -1.35f); // Bottom Right Of The Quad (Top)
        gl.glEnd();

        // below front wooden object.
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture2);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(1.5f, -0.9f, 1.35f); // Top Right Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(-1.5f, -0.9f, 1.35f); // Top Left Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(-1.5f, -1.0f, 1.5f); // Bottom Left Of The Quad (Top)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(1.5f, -1.0f, 1.5f); // Bottom Right Of The Quad (Top)
        gl.glEnd();

        // Roof numbered table object.
        gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
        gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

        gl.glTexCoord2d(1, 1);
        gl.glVertex3f(1.5f, 1.1f, -1.35f); // Top Right Of The Quad (Top)

        gl.glTexCoord2d(0, 1);
        gl.glVertex3f(-1.5f, 1.1f, -1.35f); // Top Left Of The Quad (Top)

        gl.glTexCoord2d(0, 0);
        gl.glVertex3f(-1.5f, -0.9f, 1.35f); // Bottom Left Of The Quad (Top)

        gl.glTexCoord2d(1, 0);
        gl.glVertex3f(1.5f, -0.9f, 1.35f); // Bottom Right Of The Quad (Top)
        gl.glEnd();
    }
}
