import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    private final double[] RADIUS = {10.0,15.0,23.4,40.5,-50.3};
    private final double[] NEW_RADIUS = {13.0, 16.0, -19.0, 26, 30};

    private ArrayList<Circle> circlesList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        circlesList = new ArrayList<>();
        for(int ndx = 0; ndx < RADIUS.length; ndx++){
            Circle circle = new Circle(RADIUS[ndx]);
            circlesList.add(circle);
        }

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        circlesList = null;
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        for(Circle circle : circlesList){
            System.out.println(circle);
        }
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        assert(circlesList.size() == RADIUS.length);
        for(Circle circle : circlesList){
            Circle shallow_copy = circle;
            assertEquals(circle, shallow_copy);
            Circle null_pointer = null;
            assertFalse(circle.equals(null_pointer));
            assertFalse(circle.equals("not a circle"));
        }
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
        assert(circlesList.size() == RADIUS.length);
        for(int index = 0; index < RADIUS.length; index ++){
            Circle circle = circlesList.get(index);
            Circle new_circle = new Circle(RADIUS[index]);
            assertNotSame(new_circle, circle);
            assertEquals(new_circle.hashCode(), circle.hashCode());
        }
    }

    @org.junit.jupiter.api.Test
    void getRadius() {
        assert(circlesList.size() == RADIUS.length);
        for(int index = 0; index < RADIUS.length; index++){
            double the_radius = circlesList.get(index).getRadius();
            double exp_radius = RADIUS[index] > 0 ? RADIUS[index] : 0;
            assertEquals(exp_radius, the_radius);
        }
    }

    @org.junit.jupiter.api.Test
    void setRadius() {
        assert(circlesList.size() == RADIUS.length && RADIUS.length == NEW_RADIUS.length);
        for(int index = 0; index < circlesList.size(); index++){
            Circle circle = circlesList.get(index);
            circle.setRadius(NEW_RADIUS[index]);
            double exp_radius = NEW_RADIUS[index] > 0 ? NEW_RADIUS[index] : 0;
            assertEquals(exp_radius, circle.getRadius());
        }
    }

    @org.junit.jupiter.api.Test
    void getCircumference() {
        assert(circlesList.size() == RADIUS.length);
        for(int index = 0; index < RADIUS.length; index++){
            double the_circumfrance = circlesList.get(index).getCircumference();
            double exp_circumfrance = RADIUS[index] > 0 ? 2 * Math.PI * RADIUS[index] : 0;
            assertEquals(exp_circumfrance, the_circumfrance);
        }
    }

    @org.junit.jupiter.api.Test
    void getArea() {
        assert(circlesList.size() == RADIUS.length);
        for(int index = 0; index < RADIUS.length; index++){
            double the_area = circlesList.get(index).getArea();
            double exp_area = RADIUS[index] > 0 ? Math.PI * Math.pow(RADIUS[index], 2) : 0;
            assertEquals(exp_area, the_area); // Fix the Tolerance of the getArea Function
        }
    }
}