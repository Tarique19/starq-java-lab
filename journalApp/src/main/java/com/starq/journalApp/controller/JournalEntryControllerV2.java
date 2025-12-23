package com.starq.journalApp.controller;

import com.starq.journalApp.entity.JournalEntry;
import com.starq.journalApp.exception.ResourceNotFoundException;
import com.starq.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getALl() {
        return journalEntryService.getAll();
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId) {
        /*return journalEntryService.findById(myId).orElse(null);*/
        return journalEntryService.findById(myId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
    }

    @PostMapping("/")
    public JournalEntry createEntry(@RequestBody JournalEntry journalEntry) {
        journalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(journalEntry);
        return journalEntry;

    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntriesById(@PathVariable ObjectId myId) {
         journalEntryService.deleteById(myId);
         return true;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!=null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());

        }
        journalEntryService.saveEntry(old);
        return old;

    }

}
