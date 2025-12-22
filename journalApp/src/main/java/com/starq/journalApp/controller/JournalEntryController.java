/*
package com.starq.journalApp.controller;

import com.starq.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap();

    @GetMapping
    public List<JournalEntry> getALl(){
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);

    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry journalEntry) {
         journalEntries.put(journalEntry.getId(), journalEntry);
         return true;

    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntriesById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
        return journalEntries.put(id, myEntry);

    }

}
*/
