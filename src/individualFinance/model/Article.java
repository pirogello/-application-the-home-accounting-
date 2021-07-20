package individualFinance.model;

import individualFinance.exeption.ModelExeption;
import individualFinance.saveLoad.SaveData;

import java.util.Objects;

public class Article extends Common{
	private String title;

	public Article(){}
	public Article( String title) throws ModelExeption {
		if(title.length() == 0) throw new ModelExeption(ModelExeption.TITLE_EMPTY);
		this.title = title;
	}

	@Override
	public String getValueForComboBox(){
		return title;
	}

	public  String getTitle(){
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Article{" + "title='" + title + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Article article = (Article) o;
		return title.equals(article.title);
	}

	 @Override
	 public void postEdit(SaveData data){
		 SaveData sd = data;
		for(Transaction t : sd.getTransactions())
			if(t.getArticle().equals(sd.getOldCommon())) t.setArticle(this);
	 }

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}
}
