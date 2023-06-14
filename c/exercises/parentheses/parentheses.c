#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define STACK_SIZE 100

char stack[STACK_SIZE];
int sp = 0;

void empty_stack();
bool is_empty();
bool is_full();
void push(char);
char pop();
void overflow();
void underflow();

int main(){
    printf("Input a series of braces, parentheses, and brackets:\n");
    char c;
    while((c = getchar()) != '\n'){
        switch (c){
            case '[':
            case '(':
            case '{': 
                push(c);
                break;
            case ']':
                if (pop() != '['){
                    printf("Not nested properly");
                    return 0;
                }
                break;
            case ')':
                if (pop() != '('){
                    printf("Not nested properly");
                    return 0;
                }
                break;
            case '}':
                if (pop() != '{'){
                    printf("Not nested properly");
                    return 0;
                }
                break;
            default: 
                printf("Invalid character");
                return 0;
        }
    }
    if (is_empty()){
        printf("Braces match");
    }
    else {
        printf("Braces do not match");
    }


    return 0;
}

void empty_stack(){
    sp = 0;
}

bool is_empty(){
    return sp == 0;
}

bool is_full(){
    return sp == STACK_SIZE;
}

void push(char i){
    if(sp == STACK_SIZE){
        overflow();
    }
    else {
        stack[sp++] = i;
    }
}

char pop(){
    if(sp == 0){
        underflow();
    }
    return stack[--sp];
}

void overflow(){
    printf("Stack overflow");
    exit(EXIT_FAILURE);
}

void underflow(){
    printf("Stack underflow, braces not matched");
    exit(EXIT_FAILURE);
}