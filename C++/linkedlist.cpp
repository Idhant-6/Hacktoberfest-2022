#include <iostream>
using namespace std;

struct Node{

int data;
Node *next;
};

class linkedlist{

public:
Node *head,*temp,*temp1;

linkedlist(){
    head=temp=NULL;
}

void add(int num){


    if(head==NULL){
        head=new Node;
        head->data=num;
        head->next=NULL;
        return;
    }
    temp =head;
    while(temp->next!=NULL){
        temp=temp->next;
    }
    if(head!=NULL){
        temp1=new Node;
        temp1->data=num;
        temp1->next=temp->next;
        temp->next=temp1;
        return;
    }

}

void Delete(int num){
    
    if(head->data==num){
        temp=head;
        head=temp->next;
        delete temp;
        temp=NULL;
        return;
    }
     
   
    if(head->data!=num){
        temp=head;
        while(temp!=NULL){
            if(temp->next->data==num){
        temp1=temp->next;
        temp->next=temp1->next;
        delete temp1;
        temp1=NULL;
        return;
        }
            temp=temp->next;
        }
       
        
    }

}
void print(){
    temp=head;
    while(temp!=NULL){
        cout<<temp->data<<' ';
        temp=temp->next;
    }
}

};

int main(){
    linkedlist l;
    l.add(1);
    l.add(2);
    l.add(3);
    l.print();
    l.Delete(3);
    cout<<endl;
    l.print();
   
    l.Delete(5);
    l.print();
}
