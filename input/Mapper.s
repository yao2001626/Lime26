align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc
extern Reducer_reduce2 
extern Reducer_reduce1 
; global methods declare
; global Mapper_methods
global Mapper_init 
global Mapper_map 
; global methods declare

Mapper_init:
Mapper_init_realloc:
    PUSH DWORD 32768
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Mapper_init_realloc
    MOV  DWORD [EAX + 32768 - 1*4], 0    ; next 
    MOV  DWORD [EAX + 32768 - 2*4], 0    ; a 
    MOV  DWORD [EAX + 32768 - 3*4], 0    ; e 
    MOV  DWORD [EAX + 32768 - 4*4], 0    ; index 
    MOV  DWORD [EAX + 32768 - 32 + 12], 0    ; next
    MOV  DWORD [EAX + 32768 - 32 + 8], 0     ; lock
    LEA  ECX,  [EAX + 32768 - 32 - 4]
    MOV  DWORD [EAX + 32768 - 32 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 32768 - 32]
    MOV  DWORD [EAX + 32768 - 32], ECX       ; Pre EBP
    LEA  ECX,  [Mapper_doactions]
    MOV  DWORD [EAX + 32768 - 32 - 4], ECX   ; Mapper_doactions
    ADD  DWORD EAX, 32768 - 32
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here

    ; Mapper_init_code

    MOV DWORD ECX, [ESP + 4]
    	MOV DWORD [EAX + 28], ECX
    	 
    ; init code ends here
    RET
Mapper_doactions:
Mapper_doactions_start:
    PUSH DWORD EBP
    ; CALL Mapper_action
    CALL Mapper_doMap
    POP  EBP
    CALL switch_to_sched
    JMP  Mapper_doactions_start
    RET  ; never be here
;define method Mapper_map
Mapper_map:
Mapper_map_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
Mapper_map_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Mapper_map_suspend
Mapper_map_checkguard:
    ; method guard starts here
    MOV DWORD EAX, [ECX + 20]
CMP DWORD EAX, 1
JNE Mapper_map_succeed

    ; method guard ends here
Mapper_map_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Mapper_map_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Mapper_map_start
Mapper_map_succeed:
    ; method body starts here
    	;_startproc
; %bb.0:
	sub	esp, 12
	;_def_cfa_offset 16
	mov	eax, dword   [esp + 20]
	mov	ecx, dword   [esp + 16]
	mov	dword   [esp + 8], eax
	mov	eax, dword   [esp + 16]
	mov	edx, dword   [esp + 8]
	mov	dword   [edx + 24], eax
	mov	eax, dword   [esp + 8]
	mov	dword   [eax + 20], 1
	mov	dword   [esp + 4], ecx ; 4-byte Spill
	add	esp, 12
	;ret
.Lfunc_end0:
	;.size	Mapper_map, .Lfunc_end0-Mapper_map

    ; method body ends here
Mapper_map_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
Mapper_map_ret:
    RET 
; define action
; Mapper: doMap 
Mapper_doMap:
Mapper_doMap_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    MOV DWORD EAX, [ECX + 20]
CMP DWORD EAX, 1
JE Mapper_doMap_succeed

    ; action guard end

    JMP   Mapper_doMap_checkguard_fail
Mapper_doMap_succeed:
    ; action body start
    	;_startproc
; %bb.0:
	sub	esp, 28
	;_def_cfa_offset 32
	mov	eax, dword   [esp + 32]
	mov	ecx, 2
	mov	edx, dword   [esp + 32]
	mov	edx, dword   [edx + 28]
	mov	dword   [esp + 24], eax ; 4-byte Spill
	mov	eax, edx
	cdq
	idiv	ecx
	cmp	edx, 0
	jne	.LBB1_2
; %bb.1:
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 24]
	mov	ecx, dword   [esp + 32]
	imul	eax, dword   [ecx + 24]
	mov	ecx, dword   [esp + 32]
	mov	ecx, dword   [ecx + 16]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Reducer_reduce1
	mov	dword   [esp + 20], eax ; 4-byte Spill
	jmp	.LBB1_3
.LBB1_2:
	mov	eax, dword   [esp + 32]
	mov	eax, dword   [eax + 24]
	mov	ecx, dword   [esp + 32]
	imul	eax, dword   [ecx + 24]
	mov	ecx, dword   [esp + 32]
	mov	ecx, dword   [ecx + 16]
	mov	dword   [esp], eax
	mov	dword   [esp + 4], ecx
	call	Reducer_reduce2
	mov	dword   [esp + 16], eax ; 4-byte Spill
.LBB1_3:
	mov	eax, dword   [esp + 32]
	mov	dword   [eax + 20], 0
	add	esp, 28
	;ret
.Lfunc_end1:
	;.size	Mapper_doMap, .Lfunc_end1-Mapper_doMap

    ; action body end
Mapper_doMap_checkguard_fail:
    RET