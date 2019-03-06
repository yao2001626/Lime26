	.text
	.intel_syntax noprefix
	.file	"Reducer.c"
	.globl	Reducer_reduce1         # -- Begin function Reducer_reduce1
	.p2align	4, 0x90
	.type	Reducer_reduce1,@function
Reducer_reduce1:                        # @Reducer_reduce1
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	edx, dword ptr [esp + 8]
	mov	dword ptr [edx + 32], eax
	mov	eax, dword ptr [esp + 8]
	mov	dword ptr [eax + 24], 1
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	add	esp, 12
	ret
.Lfunc_end0:
	.size	Reducer_reduce1, .Lfunc_end0-Reducer_reduce1
	.cfi_endproc
                                        # -- End function
	.globl	Reducer_reduce2         # -- Begin function Reducer_reduce2
	.p2align	4, 0x90
	.type	Reducer_reduce2,@function
Reducer_reduce2:                        # @Reducer_reduce2
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 20]
	mov	ecx, dword ptr [esp + 16]
	mov	dword ptr [esp + 8], eax
	mov	eax, dword ptr [esp + 16]
	mov	edx, dword ptr [esp + 8]
	mov	dword ptr [edx + 36], eax
	mov	eax, dword ptr [esp + 8]
	mov	dword ptr [eax + 28], 1
	mov	dword ptr [esp + 4], ecx # 4-byte Spill
	add	esp, 12
	ret
.Lfunc_end1:
	.size	Reducer_reduce2, .Lfunc_end1-Reducer_reduce2
	.cfi_endproc
                                        # -- End function
	.globl	Reducer_doReduce        # -- Begin function Reducer_doReduce
	.p2align	4, 0x90
	.type	Reducer_doReduce,@function
Reducer_doReduce:                       # @Reducer_doReduce
	.cfi_startproc
# %bb.0:
	sub	esp, 12
	.cfi_def_cfa_offset 16
	mov	eax, dword ptr [esp + 16]
	mov	ecx, 2
	mov	edx, dword ptr [esp + 16]
	mov	edx, dword ptr [edx + 16]
	mov	dword ptr [esp + 8], eax # 4-byte Spill
	mov	eax, edx
	cdq
	idiv	ecx
	cmp	edx, 0
	jne	.LBB2_2
# %bb.1:
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 32]
	mov	ecx, dword ptr [esp + 16]
	add	eax, dword ptr [ecx + 36]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 20]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Reducer_reduce1
	jmp	.LBB2_3
.LBB2_2:
	mov	eax, dword ptr [esp + 16]
	mov	eax, dword ptr [eax + 32]
	mov	ecx, dword ptr [esp + 16]
	add	eax, dword ptr [ecx + 36]
	mov	ecx, dword ptr [esp + 16]
	mov	ecx, dword ptr [ecx + 20]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Reducer_reduce2
.LBB2_3:
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 24], 0
	mov	eax, dword ptr [esp + 16]
	mov	dword ptr [eax + 28], 0
	add	esp, 12
	ret
.Lfunc_end2:
	.size	Reducer_doReduce, .Lfunc_end2-Reducer_doReduce
	.cfi_endproc
                                        # -- End function

	.ident	"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"
	.section	".note.GNU-stack","",@progbits
