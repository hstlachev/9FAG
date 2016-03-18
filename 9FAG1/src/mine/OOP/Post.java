package mine.OOP;

public class Post {
	private int postId;
	private String title;
	private int likes;
	private int dislikes;
	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Post(int postId, String title, int likes, int dislikes,String image) {
		this.postId = postId;
		this.title = title;
		this.likes = likes;
		this.dislikes = dislikes;
		this.image=image;

	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

}