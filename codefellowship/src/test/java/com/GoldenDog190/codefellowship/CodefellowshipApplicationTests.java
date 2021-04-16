package com.GoldenDog190.codefellowship;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CodefellowshipApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testSplashPage() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(content().string(containsString("<header>")))
				.andExpect(content().string(containsString("<li><a href=\"/index\">Sign Up</a></li>")))
				.andExpect(content().string(containsString("<li><a href=\"/login\">Login</a></li>")))
				.andExpect(content().string(containsString("</header>")))
				.andExpect(content().string(containsString("<h2>Please sign up or login by clicking the links above.</h2>")))
				.andExpect(content().string(containsString(" <p>This site is a social media site where you can sign up, sign in,\n" +
						"        <br /> make your own profile, make posts, and follow other profiles.</p>")))
				.andExpect(status().isOk());
	}

	@Test
	void testLoginPage() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(content().string(containsString("<header>")))
				.andExpect(content().string(containsString("<div th:replace=\"./fragments/nav :: nav-bar\"></div>")))
				.andExpect(content().string(containsString("</header>")))
				.andExpect(content().string(containsString("<h1>Login</h1>")))
				.andExpect(content().string(containsString("<form action=\"/login\" method=\"post\">")))
				.andExpect(content().string(containsString("<label for=\"username\">username</label>")))
				.andExpect(content().string(containsString("<input id=\"username\" type=\"text\" name=\"username\">")))
				.andExpect(content().string(containsString("<label for=\"password\">password</label>")))
				.andExpect(content().string(containsString("<input id=\"password\" type=\"text\" name=\"password\">")))
				.andExpect(content().string(containsString("<label for=\"firstName\">first name</label>")))
				.andExpect(content().string(containsString("<input id=\"firstName\" type=\"text\" name=\"firstName\">")))
				.andExpect(content().string(containsString("<label for=\"lastName\">last name</label>")))
				.andExpect(content().string(containsString("<input id=\"lastName\" type=\"text\" name=\"lastName\">")))
				.andExpect(content().string(containsString("<label for=\"dateOfBirth\">date of birth</label>")))
				.andExpect(content().string(containsString("<input id=\"dateOfBirth\" type=\"text\" name=\"dateOfBirth\">")))
				.andExpect(content().string(containsString("<input type=\"submit\" value=\"login\">")))
				.andExpect(content().string(containsString("</form>")))
				.andExpect(status().isOk());
	}

	@Test
	void testSignupPage() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(content().string(containsString("<header>")))
				.andExpect(content().string(containsString("<div th:replace=\"./fragments/nav :: nav-bar\"></div>")))
				.andExpect(content().string(containsString("</header>")))
				.andExpect(content().string(containsString("<h1>Users</h1>")))
				.andExpect(content().string(containsString("<h2 th:if=\"${username}\" th:text=\"'welcome' + ${username}\"></h2>")))
				.andExpect(content().string(containsString("<form action=\"/signup\" method=\"post\">")))
				.andExpect(content().string(containsString("<label for=\"username\">username</label>")))
				.andExpect(content().string(containsString("<input id=\"username\" type=\"text\" name=\"username\">")))
				.andExpect(content().string(containsString("<label for=\"password\">password</label>")))
				.andExpect(content().string(containsString("<input id=\"password\" type=\"text\" name=\"password\">")))
				.andExpect(content().string(containsString("<label for=\"firstName\">first name</label>")))
				.andExpect(content().string(containsString("<input id=\"firstName\" type=\"text\" name=\"firstName\">")))
				.andExpect(content().string(containsString("<label for=\"lastName\">last name</label>")))
				.andExpect(content().string(containsString("<input id=\"lastName\" type=\"text\" name=\"lastName\">")))
				.andExpect(content().string(containsString("<label for=\"dateOfBirth\">date of birth</label>")))
				.andExpect(content().string(containsString("<input id=\"dateOfBirth\" type=\"text\" name=\"dateOfBirth\">")))
				.andExpect(content().string(containsString("<input type=\"submit\" value=\"signup\">")))
				.andExpect(content().string(containsString("</form>")))
				.andExpect(status().isOk());
	}

}
