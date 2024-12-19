#include<stdio.h>
#include<stdlib.h>
int main()
struct node list{
    int data;
    struct node *next;
}*front = NULL,*rear = NULL,*next=NULL;
void insert();
void delete();
void display();
{
    int choice,n=1;

while(n==1){
    printf("Enter the operation need to be performed:\n");
    printf("1.Insertion\n2.Deletion\n3.Display\n4.Exit")
    scanf("%d",&choice);
    switch(choice){

        case 1:insert();
        break;
        case 2:delete();
        break;
        case 3:display();
        break;
        case 4:n=0;
        break;
        default:printf("Invalid selection\n");
    }
}
return 0;
}
void insert(){
    struct node *newnode;
    int n;
    newnode = (struct node*)malloc(sizeof (struct node));
    printf("Enter the number to be inserted :\n");
    scanf("%d",&n)
    newnode-> data = n;
    if(front == NULL && rear==NULL){
        front = newnode;
        rear = newnode; 
        
    }
    else{
        rear->next = newnode;
        rear = newnode;

    }

}
void delete(){

    if(front == NULL || front > rear){
        printf("List is empty\n");
    }
    else{

        struct node *temp;
        temp = front ;
        front = temp->next;
        printf("The deleted element is %d",temp->data);
        free(temp);
    }
}
void display(){
    struct node*p= front;
    if(front == NULL|| front >rear)
    {
        printf("The list is empty\n")
    }
    else{
    while(p!=NULL){
    printf("%d\t",p->data);
    printf("%x\n",p->next);
    p=p->next;
    }
}
}