package com.whitewalk.service;

import java.util.List;
import java.util.Map;

import com.whitewalk.dao.IAuthorDao;
import com.whitewalk.entity.Author;
import com.whitewalk.util.Autowired;
import com.whitewalk.util.Commit;

/**
 * @author 程志康
 *
 */
public class AuthorService implements IAuthorDao {

	@Autowired
	// 类名规范
	private IAuthorDao authorDao;//

	public List<Author> findAll() {

		List<Author> list = authorDao.findAll();

		return list;
	}

	@Override
	public void addAuthor(Author author) {

		authorDao.addAuthor(author);

	}

	@Override
	public Author findAuthorById(int id) {

		Author author = authorDao.findAuthorById(id);

		return author;
	}

	@Override
	public void updateAuthor(Author author) {
		authorDao.updateAuthor(author);
	}

	@Override
	public void deleteAuthor(int id) {
		authorDao.deleteAuthor(id);
	}

	public int findAuthorCount() {

		return authorDao.findAuthorCount();

	}

}
