package com.spring.henallux.firstSpringProject;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDAO;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Temporal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ApplicationTests {

    private UserDataAccess userDataAccess;
    private ProviderConverter providerConverter = new ProviderConverter();

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userDataAccess = new UserDAO(userRepository, providerConverter);
    }

    @Test
    public void testGetUsers() {
        List<UserEntity> mockedUserEntities = new ArrayList<>();

        UserEntity mockedUserEntity = new UserEntity();
        mockedUserEntity.setLogin("TestLog");
        mockedUserEntity.setMotDePasse("1234");
        mockedUserEntity.setPrenom("Guillaume");
        mockedUserEntity.setNom("Claes");
        mockedUserEntity.setRoles("USER");
        mockedUserEntity.setAccountNonExpired(true);
        mockedUserEntity.setAccountNonLocked(true);
        mockedUserEntity.setCredentialsNonExpired(true);
        mockedUserEntity.setEnabled(true);
        mockedUserEntity.setNumRue("12");
        mockedUserEntity.setCodePostal(12);
        mockedUserEntity.setEmail("test@test.com");
        mockedUserEntity.setRue("Rue");
        mockedUserEntity.setLocalite("Ville");

        UserEntity mockedUserEntity2 = new UserEntity();
        mockedUserEntity2.setLogin("log2");
        mockedUserEntity2.setMotDePasse("1234");
        mockedUserEntity2.setPrenom("Guillaume");
        mockedUserEntity2.setNom("Claes");
        mockedUserEntity2.setRoles("USER");
        mockedUserEntity2.setAccountNonExpired(true);
        mockedUserEntity2.setAccountNonLocked(true);
        mockedUserEntity2.setCredentialsNonExpired(true);
        mockedUserEntity2.setEnabled(true);
        mockedUserEntity2.setNumRue("12");
        mockedUserEntity2.setCodePostal(12);
        mockedUserEntity2.setEmail("test@test.com");
        mockedUserEntity2.setRue("Rue");
        mockedUserEntity2.setLocalite("Ville");

        mockedUserEntities.add(mockedUserEntity);
        mockedUserEntities.add(mockedUserEntity2);

        when(userRepository.findAll()).thenReturn(mockedUserEntities);

        assertEquals(userDataAccess.getUsers().size(), 2);
        assertEquals(userDataAccess.getUsers().get(0).getLogin(), "TestLog");
        assertEquals(userDataAccess.getUsers().get(1).getLogin(), "log2");

    }

    @Test
    public void testLoadByUsername() {
        UserEntity mockedUserEntity = new UserEntity();
        mockedUserEntity.setLogin("TestLog");
        mockedUserEntity.setMotDePasse("1234");
        mockedUserEntity.setPrenom("Guillaume");
        mockedUserEntity.setNom("Claes");
        mockedUserEntity.setRoles("USER");
        mockedUserEntity.setAccountNonExpired(true);
        mockedUserEntity.setAccountNonLocked(true);
        mockedUserEntity.setCredentialsNonExpired(true);
        mockedUserEntity.setEnabled(true);
        mockedUserEntity.setNumRue("12");
        mockedUserEntity.setCodePostal(12);
        mockedUserEntity.setEmail("test@test.com");
        mockedUserEntity.setRue("Rue");
        mockedUserEntity.setLocalite("Ville");

        when(userRepository.findByLogin("TestLog")).thenReturn(mockedUserEntity);

        assertEquals(userDataAccess.loadUserByUsername("TestLog").getUsername(), "TestLog");
    }
}
