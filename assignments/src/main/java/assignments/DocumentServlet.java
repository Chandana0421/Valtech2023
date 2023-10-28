package assignments;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DocumentServlet")
public class DocumentServlet extends HttpServlet {

	String path = "C:\\Users\\Chandana.N\\Downloads\\DocumentProcessorFolder\\file1.txt";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("path", path);
			req.getRequestDispatcher("document.jsp").forward(req, resp);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String submit = request.getParameter("submit");

		HashSet<String> commonWords = new HashSet<>();
		commonWords.add("is");
		commonWords.add("i");
		commonWords.add("as");
		commonWords.add("if");
		commonWords.add("and");
		commonWords.add("the");
		commonWords.add("on");
		commonWords.add("into");
		commonWords.add("does");
		commonWords.add("to");
		commonWords.add("for");
		commonWords.add("of");
		commonWords.add(",");
		commonWords.add("in");
		commonWords.add("an");
		commonWords.add("this");
		commonWords.add("hi");
		commonWords.add("here");
		commonWords.add("with");
		commonWords.add("am");
		commonWords.add("a");
		commonWords.add("it");
		commonWords.add("but");
		commonWords.add("not");
		commonWords.add("only");
		commonWords.add("also");
		commonWords.add("then");
		commonWords.add("how");
		commonWords.add("are");
		commonWords.add("you");
		commonWords.add("why");
		commonWords.add("where");
		commonWords.add("from");

		if ("ProcessText".equals(submit)) {

			ArrayList<String> words = new ArrayList<String>();
			Scanner sc = new Scanner(new File(path));
			while (sc.hasNext()) {
				String s = sc.next();
				System.out.println(s);
				words.add(s);
			}

			Map<String, Integer> wordCountMap = new HashMap<>();
			for (String word : words) {
				word = word.toLowerCase();
				if (!commonWords.contains(word)) {
					wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
				}
			}
			int count = wordCountMap.size();
			System.out.println(count);
			request.setAttribute("path", path);
			request.setAttribute("totalWordCount", count);
			request.setAttribute("wordCountMap", wordCountMap);

			request.getRequestDispatcher("results.jsp").forward(request, response);
		}
	}
}
