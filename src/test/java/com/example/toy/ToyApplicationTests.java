package com.example.toy;

import com.example.toy.entity.Board;
import com.example.toy.repository.WriteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToyApplicationTests {

	@Autowired
	private WriteRepository writeRepository;

	@Test
	void testJpa() {
		for(int i = 1; i<9; i++) {
			String ichar = Integer.toString(i);
			Board w1 = new Board();

//			w1.getUserid("user"+ichar);

			this.writeRepository.save(w1);

		}


	}

}
