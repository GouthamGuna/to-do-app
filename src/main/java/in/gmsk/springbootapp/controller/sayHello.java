/*
 * package in.gmsk.springbootapp.controller;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * @Controller public class sayHello {
 * 
 * @RequestMapping("/")
 * 
 * @ResponseBody public String sayHelloWorld() { return
 * "Hello World With Spring Boot..."; }
 * 
 * @RequestMapping("say-hello-html")
 * 
 * @ResponseBody public String sayHelloHtml() { StringBuffer sb = new
 * StringBuffer(); sb.append("<html>"); sb.append("<head>");
 * sb.append("<title> My First HTML Page</title>"); sb.append("</head>");
 * sb.append("<body>"); sb.append("My first html page with body - Changed");
 * sb.append("</body>"); sb.append("</html>");
 * 
 * return sb.toString(); }
 * 
 * @RequestMapping("home") public String JspController() { return "sayHello"; }
 * }
 */