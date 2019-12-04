import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class amazonTest {

    @org.junit.jupiter.api.Test
    void deepCopy() {
        ALNode alNode = new ALNode();
        alNode.name = "Bob";
        Assert.assertEquals("Bob", alNode.name);
        Thumb thumb = new Thumb();
        alNode.thumbList.add(thumb);
        Assert.assertSame(thumb, alNode.thumbList.get(0));
        alNode.setD(10.75);
        Assert.assertTrue(10.75 ==  alNode.getD());
    }
}