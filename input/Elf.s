align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern Shop_consult 
extern Shop_puzzled 
extern Shop_enter 
; global methods declare
; global Elf_methods
global Elf_init 
; global methods declare

Elf_init:
Elf_init_realloc:
    PUSH DWORD 4096
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Elf_init_realloc
    MOV  DWORD [EAX + 4096 - 1*4], 0    ; sh 
    MOV  DWORD [EAX + 4096 - 20 + 12], 0    ; system_next
    MOV  DWORD [EAX + 4096 - 20 + 8], 0     ; lock
    LEA  ECX,  [EAX + 4096 - 20 - 4]
    MOV  DWORD [EAX + 4096 - 20 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 4096 - 20]
    MOV  DWORD [EAX + 4096 - 20], ECX       ; Pre EBP
    LEA  ECX,  [Elf_doactions]
    MOV  DWORD [EAX + 4096 - 20 - 4], ECX   ; Elf_doactions
    ADD  DWORD EAX, 4096 - 20
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Elf_init_code

    MOV DWORD ECX, [ESP + 4]
    MOV DWORD [EAX + 16], ECX
 
    ; init code ends here
    RET
Elf_doactions:
Elf_doactions_start:
    PUSH DWORD EBP
    ; CALL Elf_action
    CALL Elf_action1
    POP  EBP
    CALL switch_to_sched
    JMP  Elf_doactions_start
    RET  ; never be here
; define action
; Elf: action1 
Elf_action1:
Elf_action1_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    ; action guard end
	JMP Elf_action1_succeed

Elf_action1_checkguard_fail:
	RET
Elf_action1_succeed:
    ; action body start
    	;_startproc
; %bb.0:
	sub	esp, 28
	;_def_cfa_offset 32
	mov	eax, dword   [esp + 36]
	mov	ecx, dword   [esp + 32]
	mov	dword   [esp + 24], eax
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 16]
	mov	edx, dword   [esp + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], edx
	mov	dword   [esp + 20], ecx ; 4-byte Spill
	call	Shop_puzzled
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 16]
	mov	ecx, dword   [esp + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Shop_enter
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 16]
	mov	ecx, dword   [esp + 24]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Shop_consult
	add	esp, 28
	;ret
.Lfunc_end0:
	;.size	Elf_action1, .Lfunc_end0-Elf_action1

    ; action body end
    RET