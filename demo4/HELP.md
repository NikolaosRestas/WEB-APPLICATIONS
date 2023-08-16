# Stoxoi

1) Maven - Dependency Management
2) Spring Boot - Back end
3) React JS - Front end
4) Git - Version Control System
5) Tests - JUnit, Mockito

How to create a new project:
(do not run again)
```cmd
PS E:\my-projects\WEB-APPLICATIONS\demo4\src\main> npx create-react-app frontend
PS E:\my-projects\WEB-APPLICATIONS\demo4\src\main> cd .\frontend\
PS E:\my-projects\WEB-APPLICATIONS\demo4\src\main\frontend> npm install -D tailwindcss
PS E:\my-projects\WEB-APPLICATIONS\demo4\src\main\frontend> npm install --save react-cookie@4.1.1 react-router-dom@5.3.0 @mui/material @emotion/react @emotion/styled
PS E:\my-projects\WEB-APPLICATIONS\demo4\src\main\frontend> npx tailwindcss init
```

How to run the project:
```cmd
npm run start
``` 

Technologies:
1) Spring Boot
2) React JS
3) Tailwind CSS - https://tailwindcss.com/docs/top-right-bottom-left
4) Material UI - https://mui.com/material-ui/react-alert/
5) Material Icons - https://mui.com/material-ui/material-icons/?query=Menu

The created page is: http://localhost:3000/

Tasks
### Add search functionality to the gyms list

Amend the existing api http://localhost:8080/gyms
to http://localhost:8080/gyms?countyId=1
where the countyId is the id of the counties list and when we call it with countyId
then it will return all the gyms where they belong to the given county

@GetMapping
public List<Gym> getGyms(@RequestParam(value = "countyId", required = false) Long countyId) {
    return gymService.getAllGyms();
}
