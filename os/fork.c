#include<stdio.h>
#include<unistd.h>
#include<sys/wait.h>

int main()
{
    pid_t pid;
    int status;
    
    pid=fork();
    
    if(pid<0)
    {
        printf("fork failed");
        return 1;
        
    }
    else if(pid==0)
    {
        printf("this is child process with pid %d \n", getpid());
         printf("parent process with pid %d \n", getppid());
    
    
    execlp("/bin/ls","ls", NULL);
     printf("this should not be printed if exec() is sucessful");
     return 0;
    }
    
    else
    {
         printf("this is parent process with pid %d \n", getpid());
          printf("child process with pid %d \n", pid);
          wait(&status);
           printf("child process excited with status %d \n ",status);
           return 0;
           
    }
     
}