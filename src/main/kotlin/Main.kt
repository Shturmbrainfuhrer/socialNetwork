data class Post(
    val id: Int, // Record identifier
    val fromId: Int, // Author's identifier
    val date: Int, // Publication time
    val text: String, // Text of the record
    val likes: Likes = Likes(),
    val repostsCount: Int = 0, // Number of reposts
    val viewsCount: Int = 0, // Information about views
    val isFavorite: Boolean = false, // In favorites
    val canEdit: Boolean = false, // Ability to edit
    val canDelete: Boolean = false // Ability to delete
)

data class Likes(
    var count: Int = 0,
    val userLikes: Boolean = false,
    val canLike: Boolean = false,
    val canPublish: Boolean = false
)

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId = 0

    fun add(post: Post): Post {
        nextId++
        posts += post.copy(id = nextId)
        return posts.last()
    }

    fun update(post: Post): Boolean{
        for ((index, oldPost) in posts.withIndex()){
            if (oldPost.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        nextId = 0
    }

    fun printAll() {
        for (post in posts) {
            print(post)
            print(' ')
        }
        println()
    }
}

fun main() {
    val likes = Likes(10)
    val post = Post(1, 1, 1632827195, "text")
    WallService.add(post)
    WallService.add(Post(1, 1, 1632827195, "text"))
    WallService.printAll()
    likes.count = 1000
    WallService.printAll()
    println(WallService.update(Post(2, 2, 1700000000, "something", Likes(50))))
    WallService.printAll()
}
