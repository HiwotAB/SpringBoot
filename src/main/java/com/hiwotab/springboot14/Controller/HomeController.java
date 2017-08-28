package com.hiwotab.springboot14.Controller;

import com.hiwotab.springboot14.Model.Director;
import com.hiwotab.springboot14.Model.Movie;
import com.hiwotab.springboot14.Repository.DirectorRepository;
import com.hiwotab.springboot14.Repository.MoiveRepository;
import com.sun.tracing.dtrace.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    MoiveRepository moiveRepository;
//    @RequestMapping("/")
//    public String index(Model model) {
//        //First lets create a director
//        Director director = new Director();
//        director.setName("Stephen Bullock");
//        director.setGenre("Sci Fi");
//
//        //Now lets create a movie
//        Movie movie = new Movie();
//        movie.setTitle("Star Movie");
//        movie.setYear(2017);
//        movie.setDescription("About Stars....");
//
//        //Add the moive to an empty list
//        Set<Movie> movies = new HashSet<Movie>();
//        movies.add(movie);
//        movie = new Movie();
//        movie.setTitle("DeathStar Ewoks");
//        movie.setYear(2011);
//        movie.setDescription("About Ewoks on the DeathStar....");
//        movies.add(movie);
//
//        //Add ther list of movie to the director's movie list
//        director.setMovies(movies);
//
//        //Save the director to the database
//        directorRepository.save(director);
//
//        //Grad all the director from the database and send them to
//        //the template
//        model.addAttribute("directors", directorRepository.findAll());
//        return "index";
//    }
    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }
    @RequestMapping("/homePage")
    public String showHomePages() {
        return "index";
    }

    @GetMapping("/addMovie")
    public String addMoiveInfo(Model model) {
        model.addAttribute("newMovie", new Movie());
        return "addMovie";
    }
    @PostMapping("/addMovie")
    public String addMoiveInfo(@Valid @ModelAttribute("newMovie") Movie movie, BindingResult result) {
     if(result.hasErrors()){
         return "addMovie";
     }



        Director director= new Director();
        director.getId();
        Set<Movie> movies = new HashSet<Movie>();
        movie.setTitle(movies.toString());
        movie.setDescription(movies.toString());
//        movie.setYear(movies.toString());
        movies.add(movie);
        director.setMovies(movies);
        movie.setDirector(director);
        //moiveRepository.save(movie);
        directorRepository.save(director);
        return "dispMovie";


    }
    @GetMapping("/addDirector")
    public String addDirectorInfo(Model model) {
        model.addAttribute("newDirector", new Director());
        return "addDirector";
    }
    @PostMapping("/addDirector")
    public String addDirectorInfo(@Valid @ModelAttribute("newDirector") Director director, BindingResult result) {
        if(result.hasErrors()){
            return "addDirector";
        }

        directorRepository.save(director);

        return "dispDirector";

    }
    @RequestMapping("/Dirupdate/{id}")
    public String updateDir(@PathVariable("id") long id, Model model){
        model.addAttribute("newDirector", directorRepository.findOne(id));
        return "addDirector";
    }
    @RequestMapping("/Movupdate/{id}")
    public String updateMov(@PathVariable("id") long id, Model model){
        model.addAttribute("newDirector", moiveRepository.findOne(id));
        return "addMovie";
    }

//    @RequestMapping("/delete/{id}")
//    public String delCourse(@PathVariable("id") long id){
//        directorRepository.delete(id);
//        return "redirect:/listStudent";
//    }

    @RequestMapping("/listDir")
    public String listAllDir(Model model){
        model.addAttribute("director", directorRepository.findAll());
        return "listDir";
    }
    @RequestMapping("/listMov")
    public String listAllMov(Model model){
        model.addAttribute("movie", moiveRepository.findAll());
        return "listMov";
    }
    @RequestMapping("/Dirdetail/{id}")
    public String showDirector(@PathVariable("id") long id, Model model){
        model.addAttribute("director", directorRepository.findOne(id));
        return "dispDirector";
    }
    @RequestMapping("/Movdetail/{id}")
    public String showMovie(@PathVariable("id") long id, Model model){
        model.addAttribute("movie", moiveRepository.findOne(id));
        return "dispMovie";
    }

    @GetMapping("/searchDirector")
    public String searchFNameMethod(Model model){
        model.addAttribute("searchDir",new Director());
        return "searchDirector";
    }

    @PostMapping("/searchDirector")
    public String searchFNameMethod(@ModelAttribute("searchDir") Director director, Model model){
        Iterable<Director>  directorIterable= directorRepository.findAllByFname(director.getFname());
        model.addAttribute("listDirectors",directorIterable);

        return "dispSearchDirector";
    }

    @GetMapping("/searchMovie")
    public String searchDishMethod(Model model){
        model.addAttribute("searchMov",new Movie());
        return "searchMovie";
    }
    @PostMapping("/searchMovie")
    public String searchDishMethod(@ModelAttribute("searchMov") Movie movie, Model model)
    {
        Iterable<Movie>  listDish= moiveRepository.findAllByTitle(movie.getTitle());
        model.addAttribute("listMoives",listDish);
        return "dispSearchMovie";
    }




}
