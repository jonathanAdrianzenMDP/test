package mil.fap.configuration;

import javax.sql.DataSource;
import mil.fap.helpers.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
	DataSource dataSource;
    
        
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select USUARIO, ENCRYTED_PASSWORD, ESTADO from t_t_usuario where usuario=?").passwordEncoder(new BCryptPasswordEncoder())
		.authoritiesByUsernameQuery(
			"select u.usuario, p.perfil from t_t_usuario_perfil t inner join t_t_perfil p on p.idperfil = t.idperfil " +
                        "inner join t_t_usuario u on u.idusuario = t.idusuario where u.usuario=?");
	}	
        
	@Override
	protected void configure(HttpSecurity http) throws Exception {
          http.authorizeRequests()
                .antMatchers("/admin/dashboard").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                      Constantes.PerfilUsuario.SUPERVISOR)
                  
                .antMatchers("/ideasInversion").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                           Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP,
                                                           Constantes.PerfilUsuario.PMI,
                                                           Constantes.PerfilUsuario.FORMULADOR,
                                                           Constantes.PerfilUsuario.EJECUCION_EMGRA,
                                                           Constantes.PerfilUsuario.SUPERVISOR,
                                                           Constantes.PerfilUsuario.UNIDAD_EJECUTORA,
                                                           Constantes.PerfilUsuario.COMITE_TRABAJO)
                  
                .antMatchers("/nuevoIOARR").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,  
                                                       Constantes.PerfilUsuario.PMI,
                                                       Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP,
                                                       Constantes.PerfilUsuario.SUPERVISOR)
                  
	  	.antMatchers("/nuevoPIP").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR, 
                                                     Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP,
                                                     Constantes.PerfilUsuario.PMI,
                                                     Constantes.PerfilUsuario.SUPERVISOR)
                
                .antMatchers("/brechaIndicador").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                            //Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP,
                                                            Constantes.PerfilUsuario.PMI,
                                                            Constantes.PerfilUsuario.SUPERVISOR)
                  
                .antMatchers("/admin/controlAcceso").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR)
                  
                .antMatchers("/admin/mantParametroValor").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR)  
                  
                .antMatchers("/admin/unidadEjecutoraInver").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR)   
                          
                .antMatchers("/seguimientoPIP").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                            Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP,
                                                            Constantes.PerfilUsuario.FORMULADOR,
                                                            Constantes.PerfilUsuario.EJECUCION_EMGRA,
                                                            Constantes.PerfilUsuario.COMITE_TRABAJO,
                                                           Constantes.PerfilUsuario.SUPERVISOR,
                                                           Constantes.PerfilUsuario.UNIDAD_EJECUTORA,
                                                           Constantes.PerfilUsuario.PMI)
                .antMatchers("/seguimientoIOARR").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                            Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP,
                                                            Constantes.PerfilUsuario.FORMULADOR,
                                                            Constantes.PerfilUsuario.EJECUCION_EMGRA,
                                                            Constantes.PerfilUsuario.COMITE_TRABAJO,
                                                           Constantes.PerfilUsuario.SUPERVISOR,
                                                           Constantes.PerfilUsuario.UNIDAD_EJECUTORA,
                                                           Constantes.PerfilUsuario.PMI)

                  
                .antMatchers("/getPIP").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                        Constantes.PerfilUsuario.PMI,
                                                        Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP,
                                                        Constantes.PerfilUsuario.SUPERVISOR) 
                
                .antMatchers("/getIOARR").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                            Constantes.PerfilUsuario.PMI,
                                                            Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP,
                                                            Constantes.PerfilUsuario.SUPERVISOR)
                
                .antMatchers("/solicitudEjecucion").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                           Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP,
                                                           Constantes.PerfilUsuario.PMI,
                                                           Constantes.PerfilUsuario.SUPERVISOR)
                 
                .antMatchers("/comiteTrabajo").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                                 Constantes.PerfilUsuario.FORMULADOR,
                                                                 Constantes.PerfilUsuario.SUPERVISOR) 
                  
                .antMatchers("/planDeTrabajo").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                               Constantes.PerfilUsuario.COMITE_TRABAJO,
                                                               Constantes.PerfilUsuario.FORMULADOR,
                                                               Constantes.PerfilUsuario.SUPERVISOR) 
                 
                .antMatchers("/p02Perfil").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                               Constantes.PerfilUsuario.COMITE_TRABAJO,
                                                               Constantes.PerfilUsuario.FORMULADOR,
                                                               Constantes.PerfilUsuario.SUPERVISOR)
                  
                .antMatchers("/expTecnicoPIP","/expTecnicoIOARR").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                                Constantes.PerfilUsuario.EJECUCION_EMGRA,
                                                                Constantes.PerfilUsuario.COMITE_TRABAJO,
                                                               Constantes.PerfilUsuario.UNIDAD_EJECUTORA,
                                                               Constantes.PerfilUsuario.SUPERVISOR)
                 
                .antMatchers("/inforConsistPIP","/inforConsistIOARR").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                               Constantes.PerfilUsuario.EJECUCION_EMGRA,
                                                               Constantes.PerfilUsuario.UNIDAD_EJECUTORA,
                                                               Constantes.PerfilUsuario.SUPERVISOR)
                                                                       
                .antMatchers("/ejecucionFisicaPIP","/ejecucionFisicaIOARR").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                               Constantes.PerfilUsuario.EJECUCION_EMGRA,
                                                               Constantes.PerfilUsuario.UNIDAD_EJECUTORA,
                                                               Constantes.PerfilUsuario.SUPERVISOR)
                                                                       
                 .antMatchers("/liquidacionInversionPIP","/liquidacionInversionIOARR").hasAnyAuthority(Constantes.PerfilUsuario.ADMINISTRADOR,
                                                               Constantes.PerfilUsuario.EJECUCION_EMGRA,
                                                               Constantes.PerfilUsuario.UNIDAD_EJECUTORA,
                                                               Constantes.PerfilUsuario.SUPERVISOR)                                                        
                  
		//.antMatchers("/admin/**", "/brechaIndicador", "/ideasInversion").hasRole(Constantes.PerfilUsuario.ADMINISTRADOR)
                .antMatchers("/api/**").permitAll()
                .antMatchers("/resources/**").permitAll()
		.and().formLogin()
                    .loginPage("/login.html")
                    .permitAll()
                    .defaultSuccessUrl("/ideasInversion")
                .and().logout().logoutUrl("/logout").permitAll()
		.and().exceptionHandling().accessDeniedPage("/DeniedPage");
         
	}
}
