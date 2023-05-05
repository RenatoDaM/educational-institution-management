package com.educational.security;

import com.educational.domain.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class JPAUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public JPAUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    O GrantedAuthority é uma interface que define a autoridade concedida a um usuário.
    É usada pelo Spring Security para realizar a autorização com base nas
    permissões atribuídas a cada usuário. O SimpleGrantedAuthority é uma
    implementação básica de GrantedAuthority, que apenas armazena uma String representando a
    autoridade do usuário.

    Neste código, é criada uma instância de SimpleGrantedAuthority com o nome da autoridade do
    usuário, que é derivado do tipo do usuário retornado do userRepository. Em seguida,
    é criada uma instância de UserDetails com as informações do usuário (nome e senha)
    e a lista de autoridades concedidas (uma lista que contém apenas a instância de
    SimpleGrantedAuthority criada anteriormente).

    A razão pela qual é utilizada uma lista List.of para as autoridades é porque um usuário pode
    ter mais de uma autoridade associada a ele. Mesmo que neste caso a lista contenha
    apenas uma autoridade, o uso da lista permite que o método seja flexível e possa lidar com
    cenários em que um usuário possa ter várias autoridades atribuídas a ele. Além disso,
    usar List.of garante que a lista seja imutável e evita a possibilidade de modificação não intencional
    na lista após sua criação.
    */

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final var user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));

        final var simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + user.getType().name());

        return new User(user.getName(), user.getPassword(), List.of(simpleGrantedAuthority));
    }
}
