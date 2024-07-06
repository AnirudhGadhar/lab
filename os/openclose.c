#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/stat.h>
#include <errno.h>

void listDirectory(const char *path) {
    DIR *dir = opendir(path);
    if (dir == NULL) {
        perror("opendir");
        return;
    }

    struct dirent *entry;
    while ((entry = readdir(dir)) != NULL) {
        printf("%s\n", entry->d_name);
    }

    if (closedir(dir) == -1) {
        perror("closedir");
    }
}
 
void createDirectory(const char *path) {
    if (mkdir(path, 0755) == -1) {
        if (errno == EEXIST) {
            printf("Directory %s already exists.\n", path);
        } else {
            perror("mkdir");
        }
    } else {
        printf("Directory %s created successfully.\n", path);
    }
}

int main() {
    const char *dirPath = "./testdir";

    // Create a directory
    createDirectory(dirPath);

    // List the contents of the current directory
    printf("Listing current directory contents:\n");
    listDirectory(".");

    // List the contents of the new directory
    printf("\nListing new directory contents:\n");
    listDirectory(dirPath);

    return 0;
}




