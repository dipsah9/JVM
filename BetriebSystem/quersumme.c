#include <stdio.h>
#include <stdbool.h>
#include <errno.h>

// Helper function to check if the input is a digit
bool isDigit(char c) {
    return c >= '0' && c <= '9';
}

// Function to calculate the digit sum from a string
int digitSum(char *input, int *len,char format) {
    int result = 0; 
    *len = 0;

    while (*input) {
        if (isDigit(*input)) {
            int temp = *input - '0';
            result += temp;
            (*len)++; 
        } else {
            errno = EINVAL;
            return -1;
        }   
        input++; 
    }

    return result;
}

// Main function to iterate over the arguments and create the output
// int  outputGenerator(int argc, char *argv[]) {
//     char format = 'd';
//     int exit  = 0;
//     for (int i = 1; i < argc; i++) { // Start from 1 to skip the program name
//         int len;
//         int result = digitSum(argv[i], &len, format);
//         if (result != -1) { 
//             printf("The alternating sum of %d Places digit  %s is %d\n", len, argv[i], result);
//         }else{
//             fprintf(stderr, "%s: ", argv[i]);
//             perror("");
//             exit = 1;
//         }
//     }
//     return exit;
// }

int main(int argc, char* argv[]) {
    char format = 'd';
    int exitStatus = 0;
    for(int i  = 1; i < argc; i++){
        int len;
        int result = digitSum(argv[i], &len, format);

        if(result != -1){
             printf("The alternating sum of %d Places digit  %s is %d\n", len, argv[i], result);
        }else{
            fprintf(stderr, "%s: ",argv[i]);
            perror("");
            exitStatus = 1;
        }
    }
    return exitStatus;
}
