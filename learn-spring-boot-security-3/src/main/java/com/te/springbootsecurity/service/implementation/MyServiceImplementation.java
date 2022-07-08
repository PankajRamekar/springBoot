/*
 * package com.te.springbootsecurity.service.implementation;
 * 
 * import java.util.Arrays; import java.util.List; import java.util.Optional;
 * import java.util.stream.Collectors;
 * 
 * import org.springframework.beans.BeanUtils; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import com.te.springbootsecurity.entity.Address; import
 * com.te.springbootsecurity.entity.AppUser; import
 * com.te.springbootsecurity.entity.Employee; import
 * com.te.springbootsecurity.entity.Role; import
 * com.te.springbootsecurity.entity.dto.RegisterDto; import
 * com.te.springbootsecurity.entity.dto.ShowDeatilsDto; import
 * com.te.springbootsecurity.repository.AddressRepository; import
 * com.te.springbootsecurity.repository.AdminRepository; import
 * com.te.springbootsecurity.repository.AppUserRepository; import
 * com.te.springbootsecurity.repository.EmployeeRepository; import
 * com.te.springbootsecurity.repository.RoleRepository; import
 * com.te.springbootsecurity.service.MyService;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * //@Slf4j
 * 
 * @RequiredArgsConstructor
 * 
 * @Service public class MyServiceImplementation implements MyService,
 * UserDetailsService { private final EmployeeRepository employeeRepository;
 * private final AdminRepository adminRepository; private final
 * AppUserRepository appUserRepositoryr; private final RoleRepository
 * roleRepository; private final AddressRepository addressRepository; private
 * final PasswordEncoder passwordEncoder;
 * 
 * @Override public ShowDeatilsDto register(RegisterDto registerDto) { // TODO
 * Logic to save the details
 * 
 * Employee employee= new Employee(); BeanUtils.copyProperties(registerDto,
 * employee); Address address = new Address();
 * address.setCity(registerDto.getCity());
 * address.setStreet(registerDto.getStreet()); employee.setAddress(address);
 * employee = employeeRepository.save(employee); Role role = new Role();
 * role.setRoleName(registerDto.getRole()); // role.setRoleId(01); AppUser
 * appUser = new AppUser(); appUser.setRoles(Arrays.asList(role));
 * appUser.setUsername(registerDto.getEmployeeId());
 * appUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));
 * role.setAppUsers(Arrays.asList(appUser)); appUserRepositoryr.save(appUser);
 * ShowDeatilsDto showDeatilsDto = new ShowDeatilsDto();
 * BeanUtils.copyProperties(registerDto, showDeatilsDto); return showDeatilsDto;
 * 
 * }
 * 
 * @Override public List<Employee> getEmployees() { // TODO Auto-generated
 * method stub List<Employee> employees = employeeRepository.findAll(); return
 * employees; }
 * 
 * @Override public ShowDeatilsDto updateEmployee(RegisterDto registerDto) {
 * Employee employee =
 * employeeRepository.findByemployeeId(registerDto.getEmployeeId());
 * BeanUtils.copyProperties(registerDto, employee); Address address = new
 * Address(); address.setCity(registerDto.getCity());
 * address.setStreet(registerDto.getStreet()); employee.setAddress(address);
 * employee = employeeRepository.save(employee); Role role = new Role();
 * role.setRoleName(registerDto.getRole()); // role.setRoleId(01); AppUser
 * appUser = new AppUser(); appUser.setRoles(Arrays.asList(role));
 * appUser.setUsername(registerDto.getEmployeeId());
 * appUser.setPassword(registerDto.getPassword());
 * role.setAppUsers(Arrays.asList(appUser)); appUserRepositoryr.save(appUser);
 * ShowDeatilsDto showDeatilsDto = new ShowDeatilsDto();
 * BeanUtils.copyProperties(registerDto, showDeatilsDto); return showDeatilsDto;
 * 
 * }
 * 
 * @Override public ShowDeatilsDto getEmployeebyId(String employeeId) { Employee
 * employee = employeeRepository.getById(employeeId); ShowDeatilsDto deatilsDto
 * = new ShowDeatilsDto(); BeanUtils.copyProperties(employee, deatilsDto);
 * return deatilsDto; }
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { // TODO Auto-generated method stub
 * Optional<AppUser> optional = appUserRepositoryr.findByUser(username); if
 * (optional.isPresent()) { AppUser appUser = optional.get();
 * List<SimpleGrantedAuthority> authorities = appUser.getRoles().stream().map(r
 * -> { SimpleGrantedAuthority simpleGrantedAuthority = new
 * SimpleGrantedAuthority(r.getRoleName()); return simpleGrantedAuthority;
 * }).collect(Collectors.toList()); return new User(appUser.getUsername(),
 * appUser.getPassword(), authorities); } throw new
 * UsernameNotFoundException("user not exist in Database"); }
 * 
 * }
 */