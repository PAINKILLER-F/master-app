package ru.freemiumhosting.master.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import ru.freemiumhosting.master.exception.GitCloneException;

@Slf4j
@Service
public class GitService {
    public void cloneGitRepo(String gitClonePath, String uri, String branch)
        throws GitCloneException {
        try (Git git = Git.cloneRepository()
            .setURI(uri)
            .setDirectory(new File(gitClonePath)) //TODO: clean folder
            .setBranch(branch)
            .call()) {
        } catch (GitAPIException ex) {
            log.error("Возникла проблема при клонировании git репозитория", ex);
            throw new GitCloneException("Возникла проблема при клонировании git репозитория: " + ex.getMessage());
        }
    }
}
