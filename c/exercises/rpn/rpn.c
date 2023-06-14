#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define STACK_SIZE 100

int stack[STACK_SIZE];
int sp = 0;

void empty_stack();
bool is_empty();
bool is_full();
void push(char);
int pop();
void overflow();
void underflow();

int main(){
    char ch;
    int num1, num2;
    for( ;; ){
    printf("Enter an RPN expression:");
    do{
        scanf(" %c", &ch);
        switch(ch){
            case '0':
                push(0);
                break;
            case '1':
                push(1);
                break;
            case '2':
                push(2);
                break;
            case '3':
                push(3);
                break;
            case '4':
                push(4);
                break;
            case '5':
                push(5);
                break;
            case '6':
                push(6);
                break;
            case '7':
                push(7);
                break;
            case '8':
                push(8);
                break;
            case '9':
                push(9);
                break;
            case '+':
                num1 = pop();
                num2 = pop();
                push(num1 + num2);
                break;
            case '-':
                num1 = pop();
                num2 = pop();
                push(num2 - num1);
                break;
            case '*':
                num1 = pop();
                num2 = pop();
                push(num1 * num2);
                break;
            case '/':
                num1 = pop();
                num2 = pop();
                push(num2 / num1);
                break; 
            case '=':
                printf("Value of expression: %d\n", pop());
                empty_stack();
                break;
            default:
                exit(EXIT_SUCCESS);       
        }

    } while(!is_empty());
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

int pop(){
    if(sp == 0){
        underflow();
    }
    return stack[--sp];
}

void overflow(){
    printf("Expression is too complex");
    exit(EXIT_FAILURE);
}

void underflow(){
    printf("Not enough operands in expression");
    exit(EXIT_FAILURE);
}