import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Scanner;

public class Post {
	private String title;
	private BufferedImage img;
	Account poster;
	private LinkedList<Comment> comments;
	private int likes;
	private int dislikes;

	private Post(String title, BufferedImage img) {
		this.title = title;
		this.img = img;
		this.comments = new LinkedList<>();
		this.likes = 0;
		this.dislikes = 0;
	}

	public static Post makePost() {
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		BufferedImage img = getUploadedImg();
		if (title != null) {
			if (title != " ") {
				Post newPost = new Post(title, img);
				return newPost;
			}
		}
		return null;
	}

	private static BufferedImage getUploadedImg() {
		checkImage(null);
		// TODO Auto-generated method stub
		return null;
	}

	private static boolean checkImage(BufferedImage img) {
		if (img != null) {
			if (img.getHeight() > 5 && img.getHeight() < 400) {
				if (img.getWidth() > 5 && img.getWidth() < 400) {
					return true;
				}
			}
		}
		return false;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public LinkedList<Comment> getComments() {
		return comments;
	}

	public void setComments(LinkedList<Comment> comments) {
		this.comments = comments;
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

	public void liked() {
		likes++;
	}

	public void disliked() {
		dislikes++;
	}

}
