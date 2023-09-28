import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun testAddPost() {
        val post = Post(0, 1, 1632827195, "text")
        val addedPost = WallService.add(post)

        assertNotEquals(0, addedPost.id) // id != 0
    }

    @Test
    fun testUpdateExistingPost() {
        val post = Post(1, 1, 1632827195, "text")
        WallService.add(post)

        val updatedPost = Post(1, 1, 1632827195, "updated text")
        val result = WallService.update(updatedPost)

        assertTrue(result) // successfully
    }

    @Test
    fun testUpdateNonExistentPost() {
        val updatedPost = Post(2, 2, 1700000000, "updated text")
        val result = WallService.update(updatedPost)

        assertFalse(result) // unsuccessfully
    }
}
