package secondslash.secondslash;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by alokit nigam on 12/3/2015.
 */
public class newsDetails {
    private String articleId,topic_id,headline,article;
    Bitmap image;



        public newsDetails(String articleId,String topic_id,String headline,String article,Bitmap image){
            this.setarticleId(articleId);
            this.settopicId(topic_id);
            this.setheadline(headline);
            this.setArticle(article);
            this.setImage(image);
        }

        public String getarticleId() {
            return articleId;
        }

        public void setarticleId(String articleId) {
            this.articleId = articleId;
        }

        public String gettopicId() {
            return topic_id;
        }

        public void settopicId(String topic_id) {
            this.topic_id = topic_id;
        }

        public String getheadline() {
            return headline;
        }

        public void setheadline(String headline) {
            this.headline = headline;
        }
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
    public Bitmap getImage(){
        return image;
    }
    public void setImage(Bitmap image){
        this.image=image;
    }
    }

