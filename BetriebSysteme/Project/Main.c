#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/stat.h>
#include <errno.h>
#include "argumentParser.h"
#include <string.h>
#include <fnmatch.h>
#include <regex.h>

int counter = 0;

char *generateFullPath(const char *path, char *name) {
    int lenPath = strlen(path);
    int lenName = strlen(name);
    char *result = NULL;

    if (path[lenPath - 1] == '/') {
        result = malloc(lenPath + lenName + 1); //1 for null terminator
        sprintf(result, "%s%s", path, name);
    } else {
        result = malloc(lenPath + lenName + 2); //1 for '/' and 1 for null terminator
        sprintf(result, "%s/%s", path, name);
    }
    return result;
}

void crawl(const char path[], int maxDepth, const char pattern[], char type, regex_t *regex) {
    DIR *dir = opendir(path);
    if (dir == NULL || maxDepth < 0) {
        perror("Unable to open directory");
        return;
    }

    struct dirent *e = NULL;
    while ((e = readdir(dir)) != NULL) {
        char *name = e->d_name;
        if (strcmp(name, ".") == 0 || strcmp(name, "..") == 0) {
            continue;
        }

        char *currentPath = generateFullPath(path, name);
        struct stat buffer;
        if (stat(currentPath, &buffer) != 0) {
            perror("stat failed");
            free(currentPath);
            continue;
        }

        if (S_ISLNK(buffer.st_mode)) {
            free(currentPath);
            continue;
        }

        int isMatch = (pattern != NULL) ? fnmatch(pattern, name, 0) == 0 : 1;
        if (isMatch && (type == 0 || (type == 'f' && S_ISREG(buffer.st_mode)) || (type == 'd' && S_ISDIR(buffer.st_mode)))) {

            if (regex != NULL && S_ISREG(buffer.st_mode)) {
                FILE *file = fopen(currentPath, "r");
                if (file != NULL) {
                    int line_number = 1;
                    char *line = NULL;
                    size_t len = 0;
                    int match_found = 0;

                    while (getline(&line, &len, file) != -1) {
                        int match = regexec(regex, line, 0, NULL, 0);
                        if (!match) {
                            printf("%s\n",line);
                            match_found++;
                            break; 
                        }
                        line_number++;
                    }
                    if (line) {
                        free(line);
                    }
                    fclose(file);
                }
            }

            if (S_ISDIR(buffer.st_mode)) {
                printf("Dir Name: %s\n", name);
                counter++;
            } else if (S_ISREG(buffer.st_mode)) {
                printf("File Name: %s\n", name);
                counter++;
            }
        }

        if (maxDepth > 0 && S_ISDIR(buffer.st_mode)){
            crawl(currentPath, maxDepth - 1, pattern, type, regex);
        }

        free(currentPath);
    }
    closedir(dir);
}

int main(int argc, char *argv[]) {
    if (initArgumentParser(argc, argv) != 0) {
        perror("Error");
        return -1;
    }

    int maxDepth;
    char *path = "/Users/dipendrasah/Desktop/ToBSorted/hanuman/JAVA/Aegi/Learning/BetriebSysteme/Project";
    char *command = getCommand();
    printf("Command: %s\n", command);

    char *depthArg = getValueForOption("maxDepth");
    if (depthArg != NULL) {
        maxDepth = atoi(depthArg);
    }

    char *pattern = getValueForOption("pattern");
    char *type = getValueForOption("type");
    char fileType = type != NULL ? type[0] : 0;

    char *sample = "dipendra";

    regex_t regex;
    if (pattern != NULL) {
        if (regcomp(&regex, sample, REG_EXTENDED)) {
            fprintf(stderr, "Could not compile regex\n");
            return EXIT_FAILURE;
        }
    }

    crawl(path, maxDepth, pattern, fileType, &regex);
    //printf("Total number of files and folders: %d\n", counter);
    
    if (pattern != NULL) {
        regfree(&regex);
    }

    return 0;
}
