# spbootcts2020
Spring Security
1. Put a Security configurtion class in which configure filter, and which Urls to allow like (Register, Login)
2. Create user via registerme, so you will username and password in user table
3. then use /login mapping and in LoginController compare with uname and pwd in step 2, if a  match then generate a token and return it
4. Next calls can use this token in Authorization header.
5. Get User in Controller using String user = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
6. Create method in repository to fetch details by User
