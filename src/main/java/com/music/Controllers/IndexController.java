// // // package com.music.Controllers;

// // // import java.io.IOException;

// // // import org.springframework.beans.factory.annotation.Autowired;
// // // import org.springframework.stereotype.Controller;
// // // import org.springframework.ui.Model;
// // // import org.springframework.web.bind.annotation.GetMapping;
// // // import org.springframework.web.bind.annotation.PostMapping;
// // // import org.springframework.web.bind.annotation.RequestParam;
// // // import org.springframework.web.multipart.MultipartFile;
// // // import com.music.services.StorageService;
// // // import com.music.Service.SongService;
// // // import com.music.models.Song;

// // // @Controller
// // // public class IndexController {
// // //     private final StorageService storageService;
// // //     private final SongService songService;
// // //     @Autowired
// // //     public IndexController(StorageService storageService, SongService songService) {
// // //         this.storageService = storageService;
// // //         this.songService = songService;
// // //     }
    
// // //     @GetMapping("/")
// // //     public String Home(Model model){
// // //         model.addAttribute("SongFileNames", storageService.getSongFileNames());
// // //         // model.addAttribute("songQueue", storageService.getSongQueue());
// // //         return "index";
// // //     }
// // //     @GetMapping("/myQueue")
// // //     public String Queue(Model model){
// // //         return "myQueue";
// // //     }

// // //     @GetMapping("/new")
// // //     public String uploadSongDetails(Model model) throws IOException {
// // //         model.addAttribute("Song", new Song());
// // //         return "music_form";
// // //     }

// // //     @PostMapping("/upload")
// // //     public String uploadSong(Song song) throws IOException {
// // //         songService.saveSong(song);
// // //         //storageService.uploadSong(file);
// // //         return "redirect:/";
// // //     }

// // //     // @GetMapping("/getQueue")

// // // }

// // // package com.music.Controllers;

// // // import java.io.IOException;
// // // import java.util.ArrayList;
// // // import java.util.List;

// // // import org.springframework.beans.factory.annotation.Autowired;
// // // import org.springframework.stereotype.Controller;
// // // import org.springframework.ui.Model;
// // // import org.springframework.web.bind.annotation.GetMapping;
// // // import org.springframework.web.bind.annotation.PostMapping;
// // // import org.springframework.web.bind.annotation.RequestBody;
// // // import org.springframework.web.bind.annotation.ResponseBody;

// // // import com.music.Repository.songRepo.SongRepository;
// // // import com.music.services.StorageService;
// // // import com.music.Service.SongService;
// // // import com.music.models.Song;

// // // import jakarta.servlet.http.HttpSession;

// // // @Controller
// // // public class IndexController {
// // //     private final StorageService storageService;
// // //     private final SongService songService;
// // //     private final SongRepository songRepository;
    
// // //     @Autowired
// // //     public IndexController(StorageService storageService, SongService songService, SongRepository songRepository) {
// // //         this.storageService = storageService;
// // //         this.songService = songService;
// // //         this.songRepository = songRepository;
// // //     }
    
// // //     @GetMapping("/")
// // //     public String Home(Model model) {
// // //         // Get all songs from database
// // //         List<Song> allSongs = songRepository.findAll();
        
// // //         // Extract just the filenames for the view
// // //         List<String> songFileNames = new ArrayList<>();
// // //         for (Song song : allSongs) {
// // //             songFileNames.add(song.getFileName());
// // //         }
        
// // //         System.out.println("Found " + songFileNames.size() + " songs in database");
        
// // //         // If no songs in DB, try getting from storage as fallback
// // //         if (songFileNames.isEmpty()) {
// // //             songFileNames = storageService.getSongFileNames();
// // //             System.out.println("Using storage fallback, found " + songFileNames.size() + " songs");
// // //         }
        
// // //         model.addAttribute("SongFileNames", songFileNames);
// // //         model.addAttribute("songQueue", storageService.getSongQueue());
// // //         return "index";
// // //     }
    
// // //     @GetMapping("/myQueue")
// // //     public String Queue(Model model) {
// // //         return "myQueue";
// // //     }

// // //     @PostMapping("/addtoqueue")
// // //     @ResponseBody
// // //     public String addToQueue(@RequestBody String songName, HttpSession session) {
// // //         storageService.addToQueue(songName);
        
// // //         // Add to session queue if needed
// // //         @SuppressWarnings("unchecked")
// // //         List<String> userQueue = (List<String>) session.getAttribute("userque");
// // //         if (userQueue == null) {
// // //             userQueue = new ArrayList<>();
// // //         }
// // //         userQueue.add(songName);
// // //         session.setAttribute("userque", userQueue);
        
// // //         return "Added to queue: " + songName;
// // //     }
// // // }

// // package com.music.Controllers;

// // import java.io.IOException;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.stereotype.Controller;
// // import org.springframework.ui.Model;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestParam;
// // import org.springframework.web.multipart.MultipartFile;
// // import com.music.services.StorageService;
// // import com.music.Service.SongService;
// // import com.music.models.Song;

// // @Controller
// // public class IndexController {
// //     private final StorageService storageService;
// //     private final SongService songService;
// //     @Autowired
// //     public IndexController(StorageService storageService, SongService songService) {
// //         this.storageService = storageService;
// //         this.songService = songService;
// //     }

// //     @GetMapping("/")
// //     public String Home(Model model){
// //         model.addAttribute("SongFileNames", storageService.getSongFileNames());
// //         // model.addAttribute("songQueue", storageService.getSongQueue());
// //         return "index";
// //     }
// //     @GetMapping("/myQueue")
// //     public String Queue(Model model){
// //         return "myQueue";
// //     }

// //     @GetMapping("/new")
// //     public String uploadSongDetails(Model model) throws IOException {
// //         model.addAttribute("Song", new Song());
// //         return "music_form";
// //     }

// //     @PostMapping("/upload")
// //     public String uploadSong(Song song) throws IOException {
// //         songService.saveSong(song);
// //         //storageService.uploadSong(file);
// //         return "redirect:/";
// //     }

// //     // @GetMapping("/getQueue")

// // }

// package com.music.Controllers;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.ResponseBody;

// import com.music.Repository.songRepo.SongRepository;
// import com.music.services.StorageService;
// import com.music.Service.SongService;
// import com.music.models.Song;

// import jakarta.servlet.http.HttpSession;

// @Controller
// public class IndexController {
//     private final StorageService storageService;
//     private final SongService songService;
//     private final SongRepository songRepository;
    
//     @Autowired
//     public IndexController(StorageService storageService, SongService songService, SongRepository songRepository) {
//         this.storageService = storageService;
//         this.songService = songService;
//         this.songRepository = songRepository;
//     }
    
//     @GetMapping("/")
//     public String Home(Model model) {
//         // Get all songs from database
//         List<Song> allSongs = songRepository.findAll();
        
//         // Extract just the filenames for the view
//         List<String> songFileNames = new ArrayList<>();
//         for (Song song : allSongs) {
//             songFileNames.add(song.getFileName());
//         }
        
//         System.out.println("Found " + songFileNames.size() + " songs in database");
        
//         // If no songs in DB, try getting from storage as fallback
//         if (songFileNames.isEmpty()) {
//             songFileNames = storageService.getSongFileNames();
//             System.out.println("Using storage fallback, found " + songFileNames.size() + " songs");
//         }
        
//         model.addAttribute("SongFileNames", songFileNames);
//         model.addAttribute("songQueue", storageService.getSongQueue());
//         return "index";
//     }
    
//     @GetMapping("/myQueue")
//     public String Queue(Model model) {
//         return "myQueue";
//     }

//     @PostMapping("/addtoqueue")
//     @ResponseBody
//     public String addToQueue(@RequestBody String songName, HttpSession session) {
//         storageService.addToQueue(songName);
        
//         // Add to session queue if needed
//         @SuppressWarnings("unchecked")
//         List<String> userQueue = (List<String>) session.getAttribute("userque");
//         if (userQueue == null) {
//             userQueue = new ArrayList<>();
//         }
//         userQueue.add(songName);
//         session.setAttribute("userque", userQueue);
        
//         return "Added to queue: " + songName;
//     }
// }

package com.music.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.music.Repository.songRepo.SongRepository;
import com.music.services.StorageService;
import com.music.Service.SongService;
import com.music.models.Song;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
    private final StorageService storageService;
    private final SongService songService;
    private final SongRepository songRepository;
    
    @Autowired
    public IndexController(StorageService storageService, SongService songService, SongRepository songRepository) {
        this.storageService = storageService;
        this.songService = songService;
        this.songRepository = songRepository;
    }
    
    @GetMapping("/")
    public String Home(Model model, HttpSession session) {
        // Try to get songs from database first
        List<Song> allSongs = songRepository.findAll();
        System.out.println("Found " + allSongs.size() + " songs in database");
        
        List<String> songFileNames;
        
        if (!allSongs.isEmpty()) {
            // If we have songs in the database, use those
            songFileNames = new ArrayList<>();
            for (Song song : allSongs) {
                songFileNames.add(song.getFileName());
                System.out.println("Song from DB: " + song.getFileName() + " by " + song.getArtist());
            }
        } else {
            // Fallback to storage if no songs in database
            songFileNames = storageService.getSongFileNames();
            System.out.println("No songs in DB, using storage service songs: " + songFileNames.size());
            
            // Sync storage songs to database if they don't exist yet
            for (String fileName : songFileNames) {
                if (!songRepository.existsSongByFileNameEquals(fileName)) {
                    Song newSong = new Song();
                    newSong.setFileName(fileName);
                    newSong.setTitle(fileName.replace(".mp3", ""));
                    newSong.setArtist("Unknown Artist");
                    songRepository.save(newSong);
                    System.out.println("Created missing DB entry for: " + fileName);
                }
            }
        }
        
        // Set model attributes for the view
        model.addAttribute("SongFileNames", songFileNames);
        model.addAttribute("songQueue", storageService.getSongQueue());
        
        // Store queue in session if not already there
        if (session.getAttribute("userque") == null) {
            session.setAttribute("userque", storageService.getSongQueue());
        }
        
        return "index";
    }
    
    @GetMapping("/myQueue")
    public String Queue(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> userQueue = (List<String>) session.getAttribute("userque");
        if (userQueue == null) {
            userQueue = storageService.getSongQueue();
            session.setAttribute("userque", userQueue);
        }
        model.addAttribute("userQueue", userQueue);
        return "myQueue";
    }

    @PostMapping("/addtoqueue")
    @ResponseBody
    public String addToQueue(@RequestBody String songName, HttpSession session) {
        // Add to storage queue
        storageService.addToQueue(songName);
        
        // Add to session queue
        @SuppressWarnings("unchecked")
        List<String> userQueue = (List<String>) session.getAttribute("userque");
        if (userQueue == null) {
            userQueue = new ArrayList<>();
        }
        userQueue.add(songName);
        session.setAttribute("userque", userQueue);
        
        return "Added to queue: " + songName;
    }
}