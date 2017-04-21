package bookman;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import util.CommonUtils;

@ManagedBean
@SessionScoped
public class FreshsafeCrudBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Book> list;
	private Book item = new Book();
	private Book beforeEditItem = null;
	private boolean edit;

	@ManagedProperty(value = "#{commonUtils}")
	private CommonUtils util;

	public void setUtil(CommonUtils util) {
		this.util = util;
	}

	@PostConstruct
	public void init() {
		list = new ArrayList<Book>();
	}

	public void add() {
		item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
		list.add(item);
		item = new Book();

		util.redirectWithGet();
	}

	public void resetAdd() {
		item = new Book();

		util.redirectWithGet();
	}

	public void edit(Book item) {
		beforeEditItem = item.clone();
		this.item = item;
		edit = true;

		util.redirectWithGet();
	}

	public void cancelEdit() {
		this.item.restore(beforeEditItem);
		this.item = new Book();
		edit = false;

		util.redirectWithGet();
	}

	public void saveEdit() {
		this.item = new Book();
		edit = false;

		util.redirectWithGet();
	}

	public void delete(Book item) throws IOException {
		list.remove(item);

		util.redirectWithGet();
	}

	public List<Book> getList() {
		return list;
	}

	public Book getItem() {
		return this.item;
	}

	public boolean isEdit() {
		return this.edit;
	}
}