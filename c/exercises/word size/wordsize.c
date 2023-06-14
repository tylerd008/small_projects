#include <stdio.h>
#include <string.h>

#define WORD_SIZE 20

int main(){

    
    char smallest_word[WORD_SIZE] = "zzzzzzzzzzzzzzzzzzzz";
    char largest_word[WORD_SIZE] = "";
    char cur_word[WORD_SIZE];

    for(; strlen(cur_word) != 4;){
        printf("Enter word:");
        scanf("%s", &cur_word);

        if(strcmp(cur_word, smallest_word) < 0){
            strcpy(smallest_word, cur_word);
        } else if (strcmp(cur_word, largest_word) > 0){
            strcpy(largest_word, cur_word);
        }
    }
    printf("Smallest word: %s\n", smallest_word);
    printf("Largest word: %s", largest_word);

    return 0;
}