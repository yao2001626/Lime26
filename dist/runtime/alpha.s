; this is the first object which contains the code of the user's "test_doTest" function

align 4
segment .data
segment .bss
segment .text

extern malloc
extern runqput
extern switch_to_sched
global alpha_init
extern lime_main

alpha_init:
	PUSH dword 32768
	CALL malloc
	ADD  ESP, 4

	MOV  dword [EAX + 32768- 4], 0			; done
    MOV  dword [EAX + 32768- 8], 0 			; next
    MOV  dword [EAX + 32768- 12], 1 		; lock
	LEA  ECX, [EAX + 32768 - 24]
	MOV  dword [EAX + 32768 - 16], ECX 		; Store Pre ESP, it is set to call alpha_doAction
	LEA  ECX, [EAX + 32768 - 20]
	MOV  dword [EAX + 32768 - 20], ECX 		; Store Pre EBP, it is set to object self
	LEA  ECX, [alpha_doAction]
	MOV  dword [EAX + 32768 - 24], ECX  	; alpha_doAction

	ADD  dword EAX, 32768-20
	PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP DWORD EAX
    POP DWORD EBP
    MOV dword [EAX + 8], 0 					; unlock
	RET

alpha_doAction:
alpha_doAction_0:
	push dword EBP
	CALL lime_main
	POP  ebp
	CALL switch_to_sched
	JMP  alpha_doAction_0
	RET   ; never return
