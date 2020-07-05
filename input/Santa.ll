; ModuleID = '/home/yaos4/Lime26/input/Santa.c'
source_filename = "/home/yaos4/Lime26/input/Santa.c"
target datalayout = "e-m:e-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct.Santa_struct = type { i32, i32, i32, i32, i32, i32, i32 }

; Function Attrs: noinline nounwind optnone uwtable
define void @Santa_back(%struct.Santa_struct*, i8*) #0 {
  %3 = alloca %struct.Santa_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Santa_struct* %0, %struct.Santa_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %5, i32 0, i32 5
  store i32 1, i32* %6, align 4
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define void @Santa_harness(%struct.Santa_struct*, i8*) #0 {
  %3 = alloca %struct.Santa_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Santa_struct* %0, %struct.Santa_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %5, i32 0, i32 4
  store i32 2, i32* %6, align 4
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define void @Santa_pull(%struct.Santa_struct*, i8*) #0 {
  %3 = alloca %struct.Santa_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Santa_struct* %0, %struct.Santa_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %5, i32 0, i32 4
  store i32 0, i32* %6, align 4
  %7 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %8 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %7, i32 0, i32 5
  store i32 0, i32* %8, align 4
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define void @Santa_puzzled(%struct.Santa_struct*, i8*) #0 {
  %3 = alloca %struct.Santa_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Santa_struct* %0, %struct.Santa_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %5, i32 0, i32 6
  store i32 3, i32* %6, align 4
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define void @Santa_enter(%struct.Santa_struct*, i8*) #0 {
  %3 = alloca %struct.Santa_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Santa_struct* %0, %struct.Santa_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %5, i32 0, i32 4
  store i32 4, i32* %6, align 4
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define void @Santa_consult(%struct.Santa_struct*, i8*) #0 {
  %3 = alloca %struct.Santa_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Santa_struct* %0, %struct.Santa_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %5, i32 0, i32 6
  %7 = load i32, i32* %6, align 4
  %8 = sub nsw i32 %7, 1
  %9 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %10 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %9, i32 0, i32 6
  store i32 %8, i32* %10, align 4
  %11 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %12 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %11, i32 0, i32 6
  %13 = load i32, i32* %12, align 4
  %14 = icmp sgt i32 %13, 0
  br i1 %14, label %15, label %18

; <label>:15:                                     ; preds = %2
  %16 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %17 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %16, i32 0, i32 4
  store i32 3, i32* %17, align 4
  br label %21

; <label>:18:                                     ; preds = %2
  %19 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %20 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %19, i32 0, i32 4
  store i32 0, i32* %20, align 4
  br label %21

; <label>:21:                                     ; preds = %18, %15
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define void @Santa_action1(%struct.Santa_struct*, i8*) #0 {
  %3 = alloca %struct.Santa_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Santa_struct* %0, %struct.Santa_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %5, i32 0, i32 4
  store i32 1, i32* %6, align 4
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define void @Santa_action2(%struct.Santa_struct*, i8*) #0 {
  %3 = alloca %struct.Santa_struct*, align 8
  %4 = alloca i8*, align 8
  store %struct.Santa_struct* %0, %struct.Santa_struct** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load %struct.Santa_struct*, %struct.Santa_struct** %3, align 8
  %6 = getelementptr inbounds %struct.Santa_struct, %struct.Santa_struct* %5, i32 0, i32 4
  store i32 3, i32* %6, align 4
  ret void
}

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"}
